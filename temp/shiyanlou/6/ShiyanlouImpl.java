public class ShiyanlouImpl implements Shiyanlou{
    @Override
    public String toUp(String s) {
        String result = "";
        try{
        if(s == null ){
            return null;
        }
        result = s.toUpperCase();
        }catch(Exception e){
            
        }
        return result;
    }
}
