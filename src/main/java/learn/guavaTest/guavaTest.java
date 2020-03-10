package learn.guavaTest;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

public class guavaTest {
    public static void main(String[] args)throws Exception{
        LoadingCache<String, User> userCache =
                CacheBuilder.newBuilder().concurrencyLevel(8)
                .expireAfterWrite(8 , TimeUnit.SECONDS)
                .refreshAfterWrite(1 , TimeUnit.SECONDS)
                .initialCapacity(5)
                .maximumSize(6)
                .recordStats()
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + "被移除了" + notification.getCause());
                    }
                })
                .build(
                        new CacheLoader<String,User>() {

                            @Override
                            public User load(String key) throws Exception {
                                System.out.println("缓存没有时，从数据库加载" + key);
                                return new User(31 , key);
                            }
                        }
                ) ;
                for(int i = 0 ; i < 10 ; i++){
                    User user = userCache.get("uid" + i) ;
                    System.out.println(user);
                }
                for(int i = 0 ; i< 10 ; i++){
                    User user = userCache.get("uid"+i) ;
                    System.out.println(user);
                }
                System.out.println("cache stats: " + userCache.stats().toString());
    }
}
class User{
    int age ;
    String name ;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                '}';
    }
}