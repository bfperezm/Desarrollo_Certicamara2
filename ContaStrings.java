
import java.io.*;
 
 
public class ContaStrings {
static char delimitador=',';
      
       public static void main(String[] args) throws IOException, NegativosNoPermitidos{
             String cadena = null;
             int suma = 0;
            try{
            	System.out.println("Valor del delimitador por defecto: "+delimitador);
	            cadena=Leer_Cadena();             
		        if(cadena!=null && cadena.length()>1)
	            	if(cadena.substring(0, 2).equals("//")){
		            	 delimitador=cadena.charAt(2);
		            	 System.out.println("Valor tomado como delimitador: "+delimitador);
		            	 cadena=Leer_Cadena();            	 
		            }             	 
	         }catch(StringIndexOutOfBoundsException st){
            	System.out.println("Cadena Vacia");
            }
            if(Validador_Negativos(cadena)==null){
            	suma=Add(cadena);
    			System.out.println("La suma de "+cadena+" es "+suma);
            }
            
            
       }
      
       static int Add(String cadena){
            
             int result=0;
             
             
            
             if(Verificar_Vacio(cadena))
                    result=0;
             else if(cadena.charAt(cadena.length()-1)==','){
            	 		System.out.println("La cadena tiene una ',' al final opcion no valida");
            	 		return 0;
            	 	}
             	  else result=Sumar_Num(cadena);
                                       
             return result;
       }
      
       static boolean Verificar_Vacio(String cadena){
             if(cadena.equals(""))
             return true;
             else
                    return false;
            
       }
      
       static String Leer_Cadena() throws IOException{
    	   String cadena=null;
    	   
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           try{
	           System.out.println("Digita la cadena: ");
	           cadena=br.readLine();
	           /*if (cadena.equals(""))
	        	   cadena=null;
	           */
	       }catch(StringIndexOutOfBoundsException st){
	    	   System.out.println("Error Leer_Cadena");
	       }          
    	   return cadena;
       }
       
       static int Sumar_Num(String cadena){
             int result=0, cont_inicio=0;                  
             int i=0;
             while(i<cadena.length()){
                    if(cadena.charAt(i)==ContaStrings.delimitador){
                    	try{                             
                                  result+=Integer.parseInt(cadena.substring(cont_inicio, i));
                                                                                                    
                           }catch(NumberFormatException e){
                                  System.err.println(e.getMessage());                               
                           }
                           cont_inicio=i+1;                       
                    }                  
                    i++;               
             }
             try{
                    result+=Integer.parseInt(cadena.substring(cadena.length()-1, cadena.length()));
             }catch(NumberFormatException e){
                    System.err.println(e.getMessage());                               
             }
             return result;
       }      
 
       static String Validador_Negativos(String cadena) throws NegativosNoPermitidos{
    	   String negativos = null;
    	   int i=0;
    	   while(i<cadena.length()){
    		   if(cadena.charAt(i)=='-'){
				   negativos+=cadena.substring(i, i+2)+", ";
    		   }
    		   
    		   i++;
    	   }
    	   
    	   if(negativos!=null){
    		   negativos=negativos.substring(4, negativos.length()-2);
    		   throw new NegativosNoPermitidos(negativos);    	   
    	   }
    		   
    	return negativos;
       }
}