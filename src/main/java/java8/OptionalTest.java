package java8;

import Data.Boy;
import Data.Girl;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test1(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
    }
    //use optional getGirlName()
    public String getGirlName(Boy boy){
        Optional<Boy> boyOptional=Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("古力"));
        return girl2.getName();
    }
    @Test
    public void test2(){
        Boy boy=null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }
}
