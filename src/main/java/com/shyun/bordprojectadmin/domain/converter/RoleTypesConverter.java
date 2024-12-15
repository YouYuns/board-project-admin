package com.shyun.bordprojectadmin.domain.converter;

import com.shyun.bordprojectadmin.domain.constant.RoleType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//지금 ROLETYPE을 SET으로 그대로 DB컬럼에 넣을려고 JAVA는 SET이지만 DB에는 문자열로 넣기 위한 작업
//예-> ["A","B","C"]이렇게 SET이있으면 컬럼에는 통쨰로 "A","B","C'이렇게 들어가게하기위함이다
//ROLE을할때 여러가지 방법이있지만 이런방법도 쓸줄알아야되서 이번에는 이렇게한다.
//TODO: 다른 방법도 공부해서 정리필요
@Converter
public class RoleTypesConverter implements AttributeConverter<Set<RoleType>, String> {

    private static final String DELIMITER = ",";

    // ENTITY -> DB로 저장할때
    @Override
    public String convertToDatabaseColumn(Set<RoleType> attribute) {
        //문자열로 join을이용해서 합치기
        //sorted는 항상 같은 순서로 나타내기 위함
        return attribute.stream().map(RoleType::name).sorted().collect(Collectors.joining(DELIMITER));
    }
    // DB-> ENTITY로 가져올때
    @Override
    public Set<RoleType> convertToEntityAttribute(String dbData ) {
        //valueOf 이름을 받아서 Enum을받는 메서드
        //enum에서 이미 가지고있는 메서드이다 : enum으로 추측되는 값을문자열로 받아서 해당하는 값이있으면 반환하는 메서드
        return Arrays.stream(dbData.split(DELIMITER)).map(RoleType::valueOf).collect(Collectors.toSet());
    }
}
