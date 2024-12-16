-- 테스트 계정
-- TODO: 테스트용이지만 비밀번호가 노출된 데이터 세팅. 개선하는 것이 좋을 지 고민해 보자.
insert into user_account (user_id, user_password, role_types, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
    ('shyun', '{noop}asdf1234','ADMIN', '윤성호', 'shyun@mail.com', 'I am shyun.', now(), 'shyun', now(), 'shyun')
;
insert into user_account (user_id, user_password, role_types, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
    ('mark', '{noop}asdf1234', 'MANAGER,DEVELOPER','mark', 'mark@mail.com', 'I am mark.', now(), 'shyun', now(), 'shyun')
;
insert into user_account (user_id, user_password, role_types, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
    ('shark', '{noop}asdf1234','USER', 'shark', 'shark@mail.com', 'I am shark.', now(), 'shyun', now(), 'shyun')
;
