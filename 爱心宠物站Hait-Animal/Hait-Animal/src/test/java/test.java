import com.wangzhen.pojo.Animal;
import com.wangzhen.pojo.Message;
import com.wangzhen.pojo.PageBean;
import com.wangzhen.pojo.User;
import com.wangzhen.service.Animal.AnimalServiceImpl;
import com.wangzhen.service.Animal.AnimalService;
import com.wangzhen.service.Message.MessageService;
import com.wangzhen.service.Message.MessageServiceImpl;
import com.wangzhen.service.User.UserService;
import com.wangzhen.service.User.UserServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *  测试DAO层代码是否运行成功
 * @author wangzhen
 * @creat 15:57
 */
public class test {
    AnimalService animalService = new AnimalServiceImpl();
    UserService userService = new UserServiceImpl();
    MessageService messageService = new MessageServiceImpl();
    @Test
    public void testForSelectAll(){
        List<Animal> animals = animalService.selectAll();
        System.out.println(animals);
    }
    @Test
    public void testForAddAnimal(){
        Animal animal = new Animal("77小猫","女","已前往喵星","爱吃鱼罐头",0);
        animalService.addAnimal(animal);
    }
    @Test
    public void testForUpdateAnimal(){
        Animal animal = new Animal(1,"77小猫","女","已前往喵星","爱吃鱼罐头",0);
        animalService.updateAnimal(animal);
    }
    @Test
    public void testForSelectByPage(){
        int begin = 2;
        int size = 5;
        PageBean<Animal> animalPageBean = animalService.selectByPage(begin, size);
        System.out.println(animalPageBean);
    }
    @Test
    public void testForSelectByPageAndCondition(){
        int begin = 1;
        int size = 5;
        Animal animal = new Animal();
//        animal.setAnimalName("dog");
        PageBean<Animal> animalPageBean = animalService.selectByPageAndCondition(begin, size, animal);
        System.out.println(animalPageBean);
    }
    @Test
    public void testForDeleteById(){
        int id = 4;
        animalService.deleteById(id);
    }
    @Test
    public void testForDeleteByIds(){
        int[] ids = new int[]{8,9,10};
        animalService.deleteByIds(ids);
    }
    @Test
    public void testForUpdateById(){
        Animal animal = new Animal(7, "豆豆", "雄性", "健在", "好吃懒做打豆豆", 77);
        animalService.updateById(animal);
    }
    @Test
    public void testForSelectAnimal(){
        int id = 1;
        Animal animal = animalService.selectAnimal(id);
        System.out.println(animal);
    }
    /**
     *  以下对userService的测试
     */
    @Test
    public void testForSelect(){
        User wangzhen = userService.select("wangzhen", "123");
        System.out.println(wangzhen);
    }
    @Test
    public void testForAdd(){
        User user = new User();
        user.setUsername("wangkunkun");
        user.setPassword("wk521102..");
        boolean register = userService.register(user);
        System.out.println(register);
    }
    @Test
    public void testForselectAdministrator(){
        String username = "wangzhen";
        String password = "wangzhen123..";
        User user = userService.selectAdministrator(username, password);
        if(user == null){
            System.out.println("登陆失败");
        }
        System.out.println("登陆成功");
    }
    @Test
    public void testForSelectLikes(){
        int id = 2;
        int likes = userService.selectLikes(id);
        System.out.println(likes);
    }
    @Test
    public void testForAddLikes(){
        int id = 1;
        userService.addLikes(id);
    }

    /**
     * 以下对 messageservice 测试
     */
    @Test
    public void testForAddMessage(){
        Message message = new Message("张三", "1314147", "宠物需要救治");
        messageService.addMessage(message);

    }
    @Test
    public void testForSelectAllMessage(){
        List<Message> messages = messageService.sellectAllMessage();
       //  希望信息按照最新展示 也就是id越大 信息越新 将原来得到的集合 逆序排列
        Object[] objects = messages.toArray();
        Object tmp;
        int length = objects.length - 1;
        for (int i = 0; i < objects.length / 2; i++, length--) {
            tmp = objects[i];
            objects[i] = objects[length];
            objects[length] =  tmp;
        }

        List a = Arrays.asList(objects);
        System.out.println(a);

    }
    @Test
    public void testForDeleteById1(){
        int id = 11;
        messageService.deleteById(id);
    }
    @Test
    public void testForDeleteByIds1(){
        int[] ids = new int[]{7,8};
        messageService.deleteByIds(ids);
    }

}
