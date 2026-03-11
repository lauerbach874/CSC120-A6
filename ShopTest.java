import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    // add your tests here 
    
    /**
     * Tests if the computer description is constructed properly
     */
    @Test
    public void testComputerDescription() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        assertEquals("2019 MacBook Pro", myComputer.description);
    }

    /**
     * Tests if the processor is constructed properly
     */
    @Test
    public void testComputerProcessorType() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        assertEquals("Intel", myComputer.processorType);
    }

    /**
     * Tests if the hard drive capacity is constructed properly
     */
    @Test
    public void testComputerHardDriveCapacity() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        assertEquals(256, myComputer.hardDriveCapacity);
    }

    /**
     * Tests if the memory is constructed properly
     */
    @Test
    public void testComputerMemory() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        assertEquals(20, myComputer.memory);
    }

    /**
     * Tests if the operating system is constructed properly
     */
    @Test
    public void testComputerOperatingSystem() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        assertEquals("High Sierra", myComputer.operatingSystem);
    }

    /**
     * Tests if the year made is constructed properly
     */
    @Test
    public void testComputerYearMade() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        assertEquals(2019, myComputer.yearMade);
    }

    /**
     * Tests if the price is constructed properly
     */
    @Test
    public void testComputerPrice() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        assertEquals(1000, myComputer.price);
    }

    /**
     * Tests if the method for setting the computer price works
     */
    @Test
    public void testSetPrice() {
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        int newPrice = 50;
        myComputer.setPrice(newPrice);
        int computerPrice = myComputer.price;
        assertSame(newPrice, computerPrice);
    }

    /**
     * Tests if the method for setting a new operating system works
     */
    @Test
    public void testSetOS(){
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        String newOS = "NEW OS";
        myComputer.setOS(newOS);
        String computerOS = myComputer.operatingSystem;
        assertSame(newOS, computerOS);
    }

    /**
     * Tests if method for getting year made works
     */
    @Test
    public void testGetYear(){
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        int yearMade = myComputer.getYear();
        assertEquals(2019, yearMade);
    }

    /**
     * Tests if the computer description is constructed properly as a string
     */
    @Test
    public void testToString(){
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        String toString = "2019 MacBook Pro" + "\n" + "Intel" + "\n" + 256 + "\n" + 16 + "\n" + "High Sierra" + "\n" + 2019 + "\n"
        + 0;
        assertEquals(toString, myComputer.toString());
    }

    /**
     * Tests if the inventory is constructed properly
     */
    @Test
    public void testCreateInventory() {
        ResaleShop myShop = new ResaleShop();
        assertNotNull(myShop.inventory);
    }

    /**
     * Tests if the orginal computer is added to the inventory 
     */
    @Test
    public void testAddComputer() {
        ResaleShop myShop = new ResaleShop();
        assertFalse(myShop.inventory.isEmpty());
    }

    /**
     * Tests if the computer is added to the shop inventory when bought
     */
    @Test 
    public void testBuy() {
        ResaleShop myShop = new ResaleShop();
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);
        
        try {
            myShop.buy(myComputer);
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        assertTrue(myShop.inventory.contains(myComputer));

    }

    /**
     * Tests if the computer is removed from the shop inventory when bought
     */
    @Test
    public void testSell() {
        ResaleShop myShop = new ResaleShop();
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2019, 1000);

        try {
            myShop.sell(myComputer); 
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        assertFalse(myShop.inventory.contains(myComputer));

    }

    /**
     * Test if the computer is properly refurbished aar the first price
     */
    @Test
    public void testRefurbishSetFirstPrice() {
        ResaleShop myShop = new ResaleShop();
        Computer myComputer = new Computer("1900 MacBook Pro", "Intel", 256, 20, "High Sierra", 1900, 1000);

        try {
            myShop.buy(myComputer);
            myShop.refurbish(myComputer, "None");
        }

        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        assertEquals(0, myComputer.price);
    }

    /**
     * Test if the computer is properly refurbished at the second price
     */
    @Test
    public void testRefurbishSetSecondPrice() {
        ResaleShop myShop = new ResaleShop();
        Computer myComputer = new Computer("2010 MacBook Pro", "Intel", 256, 20, "High Sierra", 2010, 1000);

        try {
            myShop.buy(myComputer);
            myShop.refurbish(myComputer, "None");
        }

        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        assertEquals(250, myComputer.price);
    }

    /**
     * Test if the computer is properly refurbished at the third price
     */
    @Test
    public void testRefurbishSetThirdPrice() {
        ResaleShop myShop = new ResaleShop();
        Computer myComputer = new Computer("2015 MacBook Pro", "Intel", 256, 20, "High Sierra", 2015, 1000);

        try {
            myShop.buy(myComputer);
            myShop.refurbish(myComputer, "None");
        }

        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        assertEquals(550, myComputer.price);
    }

    /**
     * Test if the computer is properly refurbished at the fourth price
     */
    @Test
    public void testRefurbishSetFourthPrice() {
        ResaleShop myShop = new ResaleShop();
        Computer myComputer = new Computer("2026 MacBook Pro", "Intel", 256, 20, "High Sierra", 2026, 1000);

        try {
            myShop.buy(myComputer);
            myShop.refurbish(myComputer, "None");
        }

        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        assertEquals(1000, myComputer.price);
    }

    /**
     * Test if updating the operating system works
     */
    @Test 
    public void testRefurbishUpdateOS() {
        ResaleShop myShop = new ResaleShop();
        Computer myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 20, "High Sierra", 2026, 1000);

        try {
            myShop.buy(myComputer);
            myShop.refurbish(myComputer, "NEW OS");
        }
        
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        assertEquals("NEW OS", myComputer.operatingSystem);

    }


}
