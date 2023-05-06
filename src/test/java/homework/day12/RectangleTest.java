import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    Rectangle myRectangle = new Rectangle(4.0, 2.5);

    @Test
    public void getLengthTest() {
        Assert.assertEquals(4.0, myRectangle.getLength(), 0.0);
    }

    @Test
    public void setLengthTest() {
        myRectangle.setLength(7.0);
        Assert.assertEquals(7.0, myRectangle.getLength(), 0.0);
    }

    @Test
    public void getWidthTest() {

        Assert.assertEquals(2.5, myRectangle.getWidth(), 0.0);
    }

    @Test
    public void setWidthTest() {
        myRectangle.setWidth(6.0);
        Assert.assertEquals(6.0, myRectangle.getWidth(), 0.0);
    }

    @Test
    public void getAreaTest() {

        Assert.assertEquals(10.0, myRectangle.getArea(), 0.0);
    }
}
