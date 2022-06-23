<h1 align="center">HAL</h1>

<img align="left" alt="C++" img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/HAL9000_Case.svg/220px-HAL9000_Case.svg.png" height="50">

<p align="center">A small Assembly-like Interpreter written in Java that can execute many instruction very fast ⚡

<img align="right" alt="C++" img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/HAL9000_Case.svg/220px-HAL9000_Case.svg.png" height="50">

<h1 align="center">Instruction Set</h1>

- ```START```     : Start program
- ```STOP```      : Stop program
- ```ADD r```     : Adds content of register r to the accumulator and saves result into accumulator (a += r)
- ```SUB```       : Subtracts accumulator with content of register r and saves result into accumulator (a -= r)  
- ```MUL```       : analog to ADD and SUB 
- ```DIV```       : analog to ADD and SUB
- ```ADDNUM n```  : Adds the number n to accumulator (a += n)
- ```SUBNUM n```  : analog to ADDNUM
- ```MULNUM n```  : analog to MULNUM
- ```DIVNUM n```  : analog to DIVUM
- ```OUT```       : print content of accumulator into input/output-unit 
- ```IN```        : read the from input/output-unit and write content into accumulator 
- ```LOAD r```    : load content of register r into accumulator (a = r)
- ```LOADNUM n``` : load specified number n into accumulator (a = n) 
- ```STORE r```   : save accumulator into register r (r = a)
- ```JUMP a```    : jump to program adress a
- ```JUMPNEG```   : jump to program adress a, if acc is negative
- ```JUMPPOS```   : jump to program adress a, if acc is positive
- ```JUMPNULL```  : jump to program adress a, if acc is 0
