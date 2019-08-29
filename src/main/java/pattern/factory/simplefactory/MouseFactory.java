package pattern.factory.simplefactory;

public class MouseFactory {
     public Mouse createMouse(String name){
         if("dell".equals(name)){
             return new DellMouse();
         }else if("hp".equals(name)){
             return new HpMouse();
         }
         return null;
     }
}
