package com.afiliate.ywchoi.web.domain.posts;

import com.afiliate.ywchoi.domain.posts.Posts;
import com.afiliate.ywchoi.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTets {

    @Autowired
    PostsRepository postsRepository;

    @After //단위테스트가 끝날때마다 수행되는 메소드. 여러 테스트가 동시에 이뤄지면 H2 DB에 데이터가 그대로 남는 것을 방지
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 제목";
        String content = "테스트 본문";

        //테이블 posts에 insert/update를 수행. (id가 존재하면 update, 없다면 insert)
        postsRepository.save(Posts.builder()
                                  .title(title)
                                  .content(content)
                                  .author("test@test.com")
                                  .build()
        );

        //posts의 데이터를 모두 조회회
        //when
       List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
