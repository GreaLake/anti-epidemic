import com.example.antiepidemic.dao.CarouselDao;
import com.example.antiepidemic.dao.impl.CarouselDaoImpl;
import com.example.antiepidemic.dao.impl.ImageDaoImpl;
import com.example.antiepidemic.result.Result;
import com.example.antiepidemic.service.CarouselService;
import com.example.antiepidemic.service.impl.CarouselServiceImpl;
import org.junit.jupiter.api.Test;

public class TestClass {
    CarouselService carouselService = new CarouselServiceImpl();
    CarouselDao carouselDao = new CarouselDaoImpl();
    @Test
    void Test(){
        ImageDaoImpl imageDao = new ImageDaoImpl();
        imageDao.insertImage("1","2",1);
    }
    @Test
    void Test1(){
        Result result = carouselService.saveCarousels("第一张图", 7L, 1L);
        System.out.println(result);
    }
    @Test
    void Test2(){
        boolean flag = carouselDao.getCarouselName("第一张图");
        System.out.println(flag);
    }
}
