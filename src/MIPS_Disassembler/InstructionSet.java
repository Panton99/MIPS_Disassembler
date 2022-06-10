//Jisoo Kim 2022 Summer
package MIPS_Disassembler;
import java.util.ArrayList;
import java.util.List;
public class InstructionSet {
    //Initialize variables
    private int opCode;
    private int src2Reg;
    private int src1Reg;
    private int destReg;
    private int func;
    private short offSet;
    //Machine instructions that have to disassemble.
    private int[] instruction = {0x032BA020, 0x8CE90014, 0x12A90003, 0x022DA822, 0xADB30020, 0x02697824, 0xAE8FFFF4, 0x018C6020, 0x02A4A825, 0x158FFFF7, 0x8ECDFFF0};
    private int address = 0x0009A040; //Initialize the start point to find the destination of address. (Starts at 9A040)

    public int[] getInstruction() {
        return instruction;
    }

    public void setInstruction(int[] instruction) {
        this.instruction = instruction;
    }

    public int getAddress() {
        return address;
    }
    public void setAddress(int address) {
        this.address = address;
    }
    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public int getSrc1Reg() {
        return src1Reg;
    }

    public void setSrc1Reg(int src1Reg) {
        this.src1Reg = src1Reg;
    }

    public int getSrc2Reg() {
        return src2Reg;
    }

    public void setSrc2Reg(int src2Reg) {
        this.src2Reg = src2Reg;
    }

    public int getDestReg() {
        return destReg;
    }

    public void setDestReg(int destReg) {
        if (opCode == 0) {
            this.destReg = destReg;
        }
    }

    public int getFunc() {
        return func;
    }

    public void setFunc(int func) {
        this.func = func;
    }

    public short getOffSet() {
        return offSet;
    }

    public void setOffSet(short offSet) {
        if (opCode != 0) {
            this.offSet = offSet;
        }
    }
}