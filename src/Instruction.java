public class Instruction
{
    /**
     * each line in the HAL-file has a line-number
     */
    public int line;
    
    /**
     * an instruction has a name (e.g. "ADDNUM")
     */
    public String instructionname;
    
    /**
     * some instructions take a operand and do something with it
     */
    public Number operand;
    
    /**
     * in case, the operand is an Integer
     */
    public int i_operand;
    
    /**
     * in case, the operand is a Float 
     */
    public double f_operand;
    
    /**
    * standard constructor sets everything to a deafult value
    */
    public Instruction()
    {
        this.line = 0;
        this.instructionname = "leer";
        this.f_operand = 0;
        this.i_operand = 0;
    }
    
    /**
     * this handles all instructions that are sensitive towards 
     * Integers or Floats and sets the operand to the fitting
     * variable
     * The aim was to prevent casting while processing instructions
     * and to save performance
     */
    public void determineInstruction()
    {
        switch (this.instructionname)
        {
            case "LOADNUM": 
            {
                if (this.i_operand != 0) 
                {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "ADDNUM": 
            {
                if (this.i_operand != 0) 
                {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "MULNUM": 
            {
                if (this.i_operand != 0) 
                {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "DIVNUM": 
            {
                if (this.i_operand != 0) 
                {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "SUBNUM": 
            {
                if (this.i_operand != 0) 
                {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            default: 
            {
                break;
            }
        }
    }
}
