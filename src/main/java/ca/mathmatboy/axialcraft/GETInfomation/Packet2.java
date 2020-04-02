package ca.mathmatboy.axialcraft.GETInfomation;

import java.io.DataInput;
import java.io.IOException;

public class Packet2 {
	
    public static String readString(DataInput par0DataInput, int par1) throws IOException
    {
        short short1 = par0DataInput.readShort();

        if (short1 > par1)
        {
            throw new IOException("Received string length longer than maximum allowed (" + short1 + " > " + par1 + ")");
        }
        else if (short1 < 0)
        {
            throw new IOException("Received string length is less than zero! Weird string!");
        }
        else
        {
            StringBuilder stringbuilder = new StringBuilder();

            for (int j = 0; j < short1; ++j)
            {
                stringbuilder.append(par0DataInput.readChar());
            }

            return stringbuilder.toString();
        }
    }
}
