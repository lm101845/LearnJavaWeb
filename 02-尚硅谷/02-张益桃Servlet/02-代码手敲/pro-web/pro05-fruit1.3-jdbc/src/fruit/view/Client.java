package fruit.view;

import fruit.controller.Menu;

/**
 * @Author liming
 * @Date 2022/5/21 12:35
 **/
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        Menu m = new Menu();
        boolean flag = true;
        while(flag){
            //调用显示主菜单的方法
            int slt = m.showMainMenu();
            switch (slt) {
                case 1:
                    //显示库存列表
                    m.showFruitList();
                    break;
                case 2:
                    m.addFruit();
                    break;
                case 3:
                    m.showFruitInfo();
                    break;
                case 4:
                    m.delFruit();
                    break;
                case 5:
                    //flag = false;
                    flag = m.exit();
                    break;
                default:
                    System.out.println("你不按套路出牌");
                    break;
            }
        }
        System.out.println("谢谢使用，再见！");
    }
}
