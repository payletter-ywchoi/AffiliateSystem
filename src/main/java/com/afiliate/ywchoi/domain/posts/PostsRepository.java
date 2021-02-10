package com.afiliate.ywchoi.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JPA용 interface. <Entity클래스, PK타입>으로 설정하면 CRUD 메소드 자동 생성.
//꼭 Entity클래스와 같은 위치에 있어야 한다.
//@Repository를 이용하지 않아도 된다
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
