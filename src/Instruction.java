public class Instruction
{
    public int line;
    public String instructionname;
    public Number operand;
    public int i_operand;
    public double f_operand;

    public Instruction()
    {
        this.line = 0;
        this.instructionname = "leer";
        this.f_operand = 0;
        this.i_operand = 0;
    }

    public void determineInstruction()
    {
        switch (this.instructionname)
        {
            case "START": {
                break;
            }
            case "STOP": {
                break;
            }
            case "OUT": {
                break;
            }
            case "IN": {
                break;
            }
            case "LOAD": {
                break;
            }
            case "LOADNUM": {
                if (this.i_operand != 0) {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "STORE": {

                break;
            }
            case "JUMPNEG": {
                break;
            }
            case "JUMPPOS": {

                break;
            }
            case "JUMPNULL": {

                break;
            }
            case "JUMP": {

                break;
            }
            case "ADD": {
                break;
            }
            case "ADDNUM": {
                if (this.i_operand != 0) {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "SUB": {
                break;
            }
            case "MUL": {
                break;
            }
            case "DIV": {
                break;
            }
            case "MULNUM": {
                if (this.i_operand != 0) {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "DIVNUM": {
                if (this.i_operand != 0) {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            case "SUBNUM": {
                if (this.i_operand != 0) {
                    this.f_operand = this.i_operand;
                }
                break;
            }
            default: {
                break;
            }
        }
    }
}
