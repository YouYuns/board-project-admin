package com.shyun.bordprojectadmin.service;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.search.MeterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class VisitCounterService {

    //meterRegistry : 마이크로쪽에서 제공하는 인터페이스 , 지표수집을 하는 대표적인 프레임워크
    private final MeterRegistry meterRegistry;

    private static final List<String> viewEndpoints = List.of(
            "/management/articels",
            "/management/articel-comments",
            "/management/user_accounts",
            "/admin/members"
    );

    public long visitCount() {
        long sum;

        try {
            sum = meterRegistry.get("http.server.requests")
                    .timers()
                    .stream()
                    .filter(timer -> viewEndpoints.contains(timer.getId().getTag("uri")))
                    .mapToLong(Timer::count)
                    .sum();
        } catch (MeterNotFoundException e) {
            sum = 0L;
        }
        return sum;
    }
}
