//Jisoo Kim 2022 Summer
package MIPS_Disassembler;

public class Disassembler {
    InstructionSet is = new InstructionSet();
    private String mips;

    public void instructInfoDisassemble() {
        for (int i=0; i < is.getInstruction().length; i++) {
            //Translation of each instruction.
            is.setOpCode((is.getInstruction()[i] & 0xFC000000) >>> 26); //set Opcode
            is.setSrc1Reg((is.getInstruction()[i] & 0x03E00000) >>> 21); //set Source 1 register
            is.setSrc2Reg((is.getInstruction()[i] & 0x001F0000) >>> 16); //set Source 2 register
            is.setDestReg((is.getInstruction()[i] & 0x0000F800) >>> 11); //set destination register
            is.setOffSet((short)((is.getInstruction()[i] & 0x0000FFFF))); //set offset
            is.setFunc((is.getInstruction()[i] & 0x0000003F)); //set function
            is.setAddress(((is.getOffSet()) << 2) + is.getAddress() + 4); //decompressed and increment to find target address

            //R format
            if((is.getOpCode() == 0) && (is.getFunc() == 32)) {
                mips = "add";
            }
            if((is.getOpCode() == 0) && (is.getFunc() == 34)) {
                mips = "sub";
            }
            if((is.getOpCode() == 0) && (is.getFunc() == 42)) {
                mips = "slt";
            }
            if((is.getOpCode() == 0) && (is.getFunc() == 36)) {
                mips = "and";
            }
            if((is.getOpCode() == 0) && (is.getFunc() == 37)) {
                mips = "or";
            }
            //I format
            if((is.getOpCode() == 0x23)) {
                mips = "lw";
            }
            if((is.getOpCode() == 0x04)) {
                mips = "beq";
            }
            if((is.getOpCode() == 0x2B)) {
                mips = "sw";
            }
            if((is.getOpCode() == 0x05)) {
                mips = "bne";
            }
            int binAddress = is.getInstruction()[i]; //Get the instruction address
            String binAddString = Integer.toHexString(binAddress); //binary to hexadecimal string
            int branchAddress = (is.getAddress()); //Get the target address of branching
            String branchAddString = Integer.toHexString(branchAddress); //binary to hexadecimal string

            //R format output
            if (is.getOpCode() == 0) {
                System.out.println(binAddString.toUpperCase() +" " + mips + " $" + is.getDestReg() + ",$" + is.getSrc1Reg() + ",$" +is.getSrc2Reg());
            }
            //I format output
            if (is.getOpCode() != 0 && is.getOpCode() !=4 && is.getOpCode() !=5) {
                System.out.println(binAddString.toUpperCase() +" " + mips + " $" + is.getSrc2Reg() + "," + is.getOffSet() + "($" + is.getSrc1Reg() + ")");
            }
            //I format branching output
            if(is.getOpCode() ==4 || is.getOpCode() ==5) {
                System.out.println(binAddString.toUpperCase() +" " + mips + " $" + is.getSrc1Reg() +",$" + is.getSrc2Reg() + ", address "+ branchAddString.toUpperCase() );
            }
        }
    }
}
