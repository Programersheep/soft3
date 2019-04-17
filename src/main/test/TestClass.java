import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
public class TestClass {
        public  static final String URL=System.getProperty("user.dir")+"/src/main/resources/";
        public  static String FILE;
        @Test
        @Parameters({"FILENAME"})
        public void getFile(String fileName){
            FILE=fileName;
            TestNG testNG = new TestNG();
            Class []classes={Test2.class};
            testNG.setTestClasses(classes);
            testNG.run();
        }

        /*
    @DataProvider(name="user")
    public Object[][] Users(){
        return new Object[][]{
                {"50+50+50+42","普通旅客+经济舱+国际航线一+10000",3000},
                {"50+50+50+20","普通旅客+经济舱+国际航线一+10000",0},
                {"0+0+0+0","不占座婴儿+头等舱+国内航线+10000",-2},
                {"50+50+10+5","不占座婴儿+头等舱+国内航线+10000",0},
                {"50+50+10+11","不占座婴儿+头等舱+国内航线+10000",-2},
                {"50+50+20+5","不占座婴儿+头等舱+国内航线+10000",-2},
                {"50+50+20+11","不占座婴儿+头等舱+国内航线+10000",-2},
                {"50+50+10+5@50+50+10+5","不占座婴儿+头等舱+国内航线+10000",-2},
                {"50+50+20+5@50+50+20+11","不占座婴儿+头等舱+国内航线+10000",-2},
                {"50+50+10+5","不占座婴儿+头等舱+国际航线一+10000",0},
                {"50+50+10+11","不占座婴儿+经济舱+国际航线一+10000",-2},
                {"50+50+10+5@50+50+10+5","不占座婴儿+经济舱+国际航线一+10000",-2},

                {"50+50+10+0","普通旅客+头等舱+国内航线+10000",-1},
                {"0+0+0+20","普通旅客+头等舱+国内航线+10000",-1},
                {"50+-20+10+20","普通旅客+头等舱+国内航线+10000",-1},
                {"-10+50+10+20","普通旅客+头等舱+国内航线+10000",-1},
                {"50+50+-10+20","普通旅客+头等舱+国内航线+10000",-1},
                {"50+50+10+-10","普通旅客+头等舱+国内航线+10000",-1},
                {"50+50+10+40","普通旅客+头等舱+国内航线+10000",0},
                {"50+50+10+60","南航明珠金卡会员或天合联盟超级精英+头等舱+国内航线+10000",-1},
                {"50+50+10+50","南航明珠金卡会员或天合联盟超级精英+公务舱+国内航线+10000",0},
                {"50+50+10+40","南航明珠金卡会员或天合联盟超级精英+经济舱+国内航线+10000",0},
                {"50+50+10+50","南航明珠银卡会员或天合联盟精英+头等舱+国内航线+10000",0},
                {"50+50+10+40","南航明珠银卡会员或天合联盟精英+公务舱+国内航线+10000",0},
                {"50+50+10+30","南航明珠银卡会员或天合联盟精英+经济舱+国内航线+10000",0},
                {"50+50+10+51","南航明珠银卡会员或天合联盟精英+头等舱+国内航线+10000",-1},

                {"50+50+10+41","普通旅客+头等舱+国内航线+10000",150},
                {"50+50+10+50","普通旅客+头等舱+国内航线+10000",1500},
                {"50+50+10+31","普通旅客+公务舱+国内航线+10000",150},
                {"50+50+10+50","普通旅客+公务舱+国内航线+10000",3000},
                {"50+50+10+21","普通旅客+经济舱+国内航线+10000",150},
                {"50+50+10+50","普通旅客+经济舱+国内航线+10000",4500},
                {"50+50+10+21","普通旅客+明珠经济舱+国内航线+10000",150},
                {"50+50+10+50","普通旅客+明珠经济舱+国内航线+10000",4500},
                {"50+50+10+41@50+50+10+20","南航明珠金卡会员或天合联盟超级精英+头等舱+国内航线+10000",150},
                {"50+50+10+40@50+50+10+21","南航明珠金卡会员或天合联盟超级精英+头等舱+国内航线+10000",150},
                {"50+50+10+50@50+50+10+20","南航明珠金卡会员或天合联盟超级精英+头等舱+国内航线+10000",1500},
                {"50+50+10+50@50+50+10+50","南航明珠金卡会员或天合联盟超级精英+头等舱+国内航线+10000",6000},
                {"50+50+10+40@50+50+10+10@50+50+10+11","南航明珠金卡会员或天合联盟超级精英+头等舱+国内航线+10000",150},
                {"50+50+10+40@50+50+10+11","南航明珠银卡会员或天合联盟精英+头等舱+国内航线+10000",150},
                {"50+50+10+41@50+50+10+10","南航明珠银卡会员或天合联盟精英+头等舱+国内航线+10000",150},
                {"50+50+10+40@50+50+10+10@50+50+10+10","南航明珠银卡会员或天合联盟精英+头等舱+国内航线+10000",1500},
                {"50+50+10+41","留学生、劳务、海员+头等舱+国内航线+10000",150},
                {"50+50+10+40@50+50+10+10","留学生、劳务、海员+头等舱+国内航线+10000",1500},
                {"50+50+10+50","留学生、劳务、海员+头等舱+国内航线+10000",1500},
                {"50+50+10+41","儿童、占座婴儿+头等舱+国内航线+10000",150},
                {"50+50+10+50","儿童、占座婴儿+头等舱+国内航线+10000",1500},
                {"50+50+10+30@50+50+10+21","南航明珠金卡会员或天合联盟超级精英+公务舱+国内航线+10000",150},
                {"50+50+10+31@50+50+10+20","南航明珠金卡会员或天合联盟超级精英+公务舱+国内航线+10000",150},
                {"50+50+10+30@50+50+10+20@50+50+10+10","南航明珠金卡会员或天合联盟超级精英+公务舱+国内航线+10000",1500},
                {"50+50+10+20@50+50+10+21","南航明珠金卡会员或天合联盟超级精英+经济舱+国内航线+10000",150},
                {"50+50+10+41","南航明珠金卡会员或天合联盟超级精英+经济舱+国内航线+10000",150},
                {"50+50+10+31","南航明珠银卡会员或天合联盟精英+经济舱+国内航线+10000",150},

                {"50+50+10+32@50+50+10+32@50+50+10+32","普通旅客+头等舱+国际航线一+10000",0},
                {"50+50+58+32","普通旅客+头等舱+国际航线一+10000",0},
                {"50+50+10+32@50+50+10+32","普通旅客+公务舱+国际航线一+10000",0},
                {"50+50+58+23@50+50+10+23","普通旅客+经济舱+国际航线一+10000",0},
                {"50+50+58+32@50+50+10+32@50+50+10+32@50+50+10+20","南航明珠金卡会员或天合联盟超级精英+头等舱+国际航线一+10000",0},
                {"50+50+58+32@50+50+10+32@50+50+10+20","南航明珠金卡会员或天合联盟超级精英+公务舱+国际航线一+10000",0},
                {"50+50+58+23@50+50+10+23@50+50+10+20","南航明珠金卡会员或天合联盟超级精英+经济舱+国际航线一+10000",0},
                {"50+50+58+23@50+50+10+23@50+50+10+20","南航明珠金卡会员或天合联盟超级精英+明珠经济舱+国际航线一+10000",0},
                {"50+50+58+32@50+50+10+32@50+50+10+32@50+50+10+10","南航明珠银卡会员或天合联盟精英+头等舱+国际航线一+10000",0},
                {"50+50+58+23@50+50+10+23@50+50+10+10","南航明珠银卡会员或天合联盟精英+经济舱+国际航线一+10000",0},
                {"50+50+58+32@50+50+10+32@50+50+10+32@50+50+10+32","留学生、劳务、海员+头等舱+国际航线一+10000",0},
                {"50+50+58+33@50+50+10+33@50+50+10+33","普通旅客+头等舱+国际航线一+10000",9000},
                {"50+50+60+32@50+50+60+32@50+60+50+32","普通旅客+头等舱+国际航线一+10000",3000},
                {"50+50+60+33@50+50+60+33@50+60+50+33","普通旅客+头等舱+国际航线一+10000",12000},
                {"50+50+50+32@50+50+50+32@50+50+50+32@50+50+50+32","普通旅客+头等舱+国际航线一+10000",1000},
                {"50+50+50+32@50+50+50+32@50+50+50+32@50+50+50+32@50+50+50+32","普通旅客+头等舱+国际航线一+10000",3000},
                {"50+50+50+33@50+50+60+32@50+50+50+32@50+50+50+32@50+50+50+32","普通旅客+头等舱+国际航线一+10000",7000}


        };
    }
    */

    }
class Test2{
    @Test(dataProvider = "user")
    public void test(String a,String b,String c){
        int ic=Integer.parseInt(c);
        Search s=new Search();
        int res=s.TestIN(a,b,ic);
        Assert.assertEquals(res,ic);
    }
    @DataProvider(name = "user")
    public  Object[][] getExcelData(){
        ArrayList<ArrayList<String>>flight=new ArrayList<ArrayList<String>>();
        try{
            // 创建输入流，读取Excel
            File file=new File(TestClass.URL+TestClass.FILE);
            InputStream is = new FileInputStream(file);
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for(int i=0;i<sheet_size;i++){
                Sheet readsheet=wb.getSheet(i);
                int rsRows=readsheet.getRows();
                int rsClomns=readsheet.getColumns();
                for(int j=0;j<rsRows;j++){
                    ArrayList<String>info=new ArrayList<String>();
                    for(int k=0;k<rsClomns;k++){
                        Cell cell=readsheet.getCell(k,j);
                        String str=cell.getContents();
                        info.add(str);
                    }
                    flight.add(info);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 定义一个object[][] 的二维数组，存放list中的值
        Object[][] results = new Object[flight.size()][];
        // 设置二维数组每行的值，
        for (int a = 0; a < flight.size(); a++) {
            results[a]=new Object[3];
            for(int j=0;j<3;j++){
                results[a][j]=flight.get(a).get(j);
                //System.out.println(results[a][j]);
            }
        }
        return results;
    }
}



