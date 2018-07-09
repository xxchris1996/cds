library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;
entity elepro is	
port(	
  buttonclk:in std_logic;    --按钮时钟信号                                                 
  liftclk: in std_logic;       --电梯时钟信号                                               
  reset:in std_logic;         --复位键                                                
  f1upbutton:in std_logic;    --一楼上升按钮                                                
  f2upbutton:in std_logic;    --二楼上升按钮
  f3upbutton:in std_logic;    --三楼上升按钮                                                
  f4upbutton:in std_logic;    --四楼上升按钮
  f5upbutton:in std_logic;    --五楼上升按钮                                                
  f2dnbutton:in std_logic;    --二楼下降按钮                                                
  f3dnbutton:in std_logic;    --三楼下降按钮
  f4dnbutton:in std_logic;    --四楼下降按钮                                                
  f5dnbutton:in std_logic;    --五楼下降按钮
  f6dnbutton:in std_logic;    --六楼下降按钮                                                
  fuplight:buffer std_logic_vector(6 downto 1);   --上升指示灯                              
  fdnlight:buffer std_logic_vector(6 downto 1);   --下降指示灯                            
  stop1button,stop2button,stop3button,stop4button,stop5button,stop6button:in std_logic;        --电梯内部按钮                   
  stoplight:buffer std_logic_vector(6 downto 1);  --内部停止指示灯                           
  position:buffer integer range 1 to 6;     --楼层位置显示                                
  doorlight:out std_logic;               --电梯门指示灯 ‘1’ 开 ‘0’关                                  
  udsig:buffer std_logic );      --‘0’处于上升模式，‘1’处于下降模式                                  
end elepro;
architecture art of elepro is 
 type lift_state is     (stopon1,dooropen,doorclose,doorwait4,up,down,stop);   --电梯所处的7个状态
signal mylift:lift_state;      --内部电梯状态信号
signal clearup:std_logic;     --上升清除信号                                               
signal cleardn:std_logic;     --下降清除信号                                         
begin
controllift:process(reset,liftclk)                                            
variable pos:integer range 1 to 6;     --楼层位置变量                              
begin
if reset='1' then                                                             
   mylift<=stopon1;    --起始状态
   clearup<='0';        --上楼信号清除
   cleardn<='0';        --下楼信号清除
   pos:=1;              --处于一楼
   position<=1;         --处于一楼
else
   if liftclk'event and liftclk='1' then          --四秒后门关                              
     case mylift is
       when stopon1   => 
                         position<=1;           --电梯处于一楼
                         pos:=1;
                         mylift<=doorwait4;                                                           
       when doorwait4 => mylift<=doorclose;                                                           
       when doorclose =>
            doorlight<='0';                 --电梯门关
            clearup<='0';
            cleardn<='0';                                                            
            if udsig='0' then              --电梯处于上升模式                                               
              if position=6 then                                                         
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000" then 
                     udsig<='1';mylift<=doorclose;
                 elsif stoplight(6)='1' or fdnlight(6)='1'   then  	
                     udsig<='0';mylift<=stop;                                                           
                 else udsig<='1';mylift<=down;                                            
                 end if;                                    
              elsif position=5 then                                                  
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='0';mylift<=doorclose;                                                      
                 elsif stoplight(6)='1' or fdnlight(6)='1'   then  	
                     udsig<='0';mylift<=up;
                 elsif stoplight(5)='1' or fuplight(5)='1'   then  	
                     udsig<='0';mylift<=stop;    
                 else udsig<='1';mylift<=down;                                            
                 end if;
             elsif position=4 then                                                  
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='0';mylift<=doorclose;                                                      
                 elsif stoplight(4)='1' or fuplight(4)='1'   then  	
                     udsig<='0';mylift<=stop; 
                 elsif stoplight>"001000" or fdnlight>"001000" or fuplight>"001000"   then  
                     udsig<='0';mylift<=up;
                 else udsig<='1';mylift<=down;                                            
                 end if;
             elsif position=3 then                                                  
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='0';mylift<=doorclose;                                                      
                 elsif stoplight>"000100" or fdnlight>"000100" or fuplight>"000100"   then 
                     udsig<='0';mylift<=up;
                 elsif stoplight(3)='1' or fuplight(3)='1'   then  	
                     udsig<='0';mylift<=stop; 
                 else udsig<='1';mylift<=down;                                            
                 end if;
             elsif position=2 then                                                  
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='0';mylift<=doorclose;                                                      
                 elsif stoplight>"000010" or fdnlight>"000010" or fuplight>"000010"   then 
                     udsig<='0';mylift<=up;
                 elsif stoplight(2)='1' or fuplight(2)='1'   then  	
                     udsig<='0';mylift<=stop; 
                 else udsig<='1';mylift<=down;                                            
                 end if;
              elsif position=1 then                                                        
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='0';mylift<=doorclose;
                 elsif stoplight(1)='1' or fuplight(1)='1'   then  	
                     udsig<='0';mylift<=stop;                                                           
                 else udsig<='0';mylift<=up;
                 end if;
              end if;
           elsif udsig='1' then                                                         
              if position=1 then                                                         
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='0';mylift<=doorclose;
                 elsif stoplight(1)='1' or fuplight(1)='1'   then  	
                     udsig<='0';mylift<=stop;                                                         
                 else udsig<='0'; mylift<=up;                                                  
                 end if; 
              elsif position=2 then                                                        
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='1';mylift<=doorclose;  
                 elsif stoplight(2)='1' or fdnlight(2)='1'   then  	
                     udsig<='1';mylift<=stop;                                                      
                 elsif stoplight<"000010" or fdnlight<"000010" or fuplight<"000010"   then   
                     udsig<='1';mylift<=down;                                                             
                 else udsig<='0'; mylift<=up;                                                  
                 end if;
              elsif position=3 then                                                        
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='1';mylift<=doorclose;    
                 elsif stoplight(3)='1' or fdnlight(3)='1'   then  	
                     udsig<='1';mylift<=stop;                                                      
                 elsif stoplight<"000100" or fdnlight<"000100" or fuplight<"000100"   then   
                     udsig<='1';mylift<=down;                                                              
                 else udsig<='0'; mylift<=up;                                                  
                 end if;
              elsif position=4 then                                                        
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='1';mylift<=doorclose; 
                 elsif stoplight(4)='1' or fdnlight(4)='1'   then  	
                     udsig<='1';mylift<=stop;                                                         
                 elsif stoplight<"001000" or fdnlight<"001000" or fuplight<"001000"   then   
                     udsig<='1';mylift<=down;                                                              
                 else udsig<='0'; mylift<=up;                                                  
                 end if;
              elsif position=5 then                                                        
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                     udsig<='1';mylift<=doorclose;
                 elsif stoplight(5)='1' or fdnlight(5)='1'   then  	
                     udsig<='1';mylift<=stop;                                                          
                 elsif stoplight<"010000" or fdnlight<"010000" or fuplight<"010000"   then   
                     udsig<='1';mylift<=down;                                                              
                 else udsig<='0'; mylift<=up;                                                  
                 end if;
              elsif position=6 then                                                       
                 if stoplight="000000" and fuplight="000000" and fdnlight="000000"  then  
                      udsig<='1';mylift<=doorclose;
                 elsif stoplight(6)='1' or fdnlight(6)='1'   then  	
                     udsig<='1';mylift<=stop;    
                 else udsig<='1'; mylift<=down;
                 end if;
              end if;
             end if;
      when up =>      position<=position+1;pos:=pos+1;                                                                                        
             if  position <6 and( stoplight(pos)='1' or fuplight(pos)='1') then  
                      mylift<=stop;--if fuplight="000000" and stoplight="000000" and fdnlight<"100000" then  mylift<=down;udsig<='1'; end if;
               elsif position =6 and (stoplight(pos)='1' or fdnlight(pos)='1')   then 
                      mylift<=stop;
               elsif position <6 and ( fuplight="000000" and fdnlight(pos)='1' and stoplight <= fdnlight)  then
					  mylift<=stop;
			   --elsif  position<6 and fuplight="000000" and stoplight="000000" and fdnlight<"100000" then udsig<='1';mylift<=doorclose;
               else mylift<=doorclose;
             end if;
      when down =>                                                       
                 position<=position-1; pos:=pos-1;                                                  
             if  position>1 and (stoplight(pos)='1' or fdnlight(pos)='1') 
		then    mylift<=stop;--if fdnlight="000000" and stoplight="000000" and fuplight>"000001" then mylift<=up;udsig<='0'; end if;
 elsif position=1 and (stoplight(pos)='1' or fuplight(pos)='1')
         then    mylift<=stop;
	elsif position>1 and fdnlight="000000" and fuplight(pos)='1' and stoplight <= fuplight
		 then    mylift<=stop; 
    elsif  position>1 and fdnlight="000000" and stoplight="000000" and fuplight>"000001" then udsig<='0'; mylift<=doorclose;
 else        mylift<=doorclose;
end if;
         when stop     =>   mylift<=dooropen;                                                                                                                   
         when dooropen =>        
  doorlight<='1';
if udsig='0' then
if position<=6 and (stoplight(position)='1' or fuplight(position)='1' ) then clearup<='1';
elsif fuplight="000000" and fdnlight(position)='1' then cleardn<='1';
elsif position=6 and (fdnlight(pos)='1' or stoplight(pos)='1')  then cleardn<='1';
else clearup<='0';cleardn<='0';
end if; 
elsif udsig='1' then
if position>=1 and (stoplight(position)= '1' or fdnlight(position)='1') then 
cleardn<='1';
elsif fdnlight="000000" and fuplight(position)='1' then clearup<='1';
elsif position=1 and fuplight(pos)='1' then clearup<='1';
else clearup<='0';cleardn<='0'; 
end if;
end if;
mylift<=doorwait4;
      end case;
    end if;
  end if;
end process controllift;
controllight:process(reset,buttonclk)                                                                 
begin
  if reset='1' then                                                             
     stoplight<="000000"; fuplight<="000000";fdnlight<="000000";
  elsif buttonclk'event and buttonclk='1' then   
       if clearup='1' then                                                     
           stoplight(position)<='0';fuplight(position)<='0';                              
         elsif  f1upbutton='1' then fuplight(1)<='1';
         elsif f2upbutton='1' then fuplight(2)<='1';
         elsif f3upbutton='1' then fuplight(3)<='1';
         elsif f4upbutton='1' then fuplight(4)<='1';
         elsif f5upbutton='1' then fuplight(5)<='1';   
         end if;                                                                      
       if cleardn='1' then                                                          
          stoplight(position)<='0'; fdnlight(position)<='0';                            
          elsif f2dnbutton='1' then fdnlight(2)<='1';
         elsif f3dnbutton='1' then fdnlight(3)<='1';
         elsif f4dnbutton='1' then fdnlight(4)<='1';
         elsif f5dnbutton='1' then fdnlight(5)<='1';
         elsif f6dnbutton='1' then fdnlight(6)<='1';
       end if;                                                                       
      if stop1button='1' then stoplight(1)<='1';
         elsif stop2button='1' then stoplight(2)<='1';
         elsif stop3button='1' then stoplight(3)<='1';
         elsif stop4button='1' then stoplight(4)<='1';
         elsif stop5button='1' then stoplight(5)<='1';
         elsif stop6button='1' then stoplight(6)<='1';
      end if;                                                                       
  end if;
end process controllight;
end art;
