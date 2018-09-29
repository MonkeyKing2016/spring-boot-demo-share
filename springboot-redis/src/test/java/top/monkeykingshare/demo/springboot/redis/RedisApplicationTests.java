package top.monkeykingshare.demo.springboot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOperations;

	@Test
	public void valueOperations() {
		String key = "redis:test:valueOperations:01";
		valueOperations.set(key,"HelloWord");
		String result = valueOperations.get(key);
		System.out.println(result);
	}

	@Test
	public void contextLoads() {
		String key = "redis:test:01";
		redisTemplate.opsForValue().set(key,"HelloWord");
		String result = redisTemplate.opsForValue().get(key);
		System.out.println(result);
	}

}
