/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.packets;

import io.netty.buffer.ByteBuf;
import reborncore.common.packets.SimplePacket;
import techreborn.tiles.TileAesu;

import java.io.IOException;

public class PacketAesu extends SimplePacket {

	int buttonID;
	TileAesu aesu;

	public PacketAesu() {
	}

	public PacketAesu(int buttonID, TileAesu aesu) {
		this.aesu = aesu;
		this.buttonID = buttonID;
	}

	@Override
	public void writeData(ByteBuf out) throws IOException {
		SimplePacket.writeTileEntity(aesu, out);
		out.writeInt(buttonID);
	}

	@Override
	public void readData(ByteBuf in) throws IOException {
		this.aesu = (TileAesu) SimplePacket.readTileEntity(in);
		buttonID = in.readInt();
	}

	@Override
	public void execute() {
		if (!aesu.getWorld().isRemote) {
			aesu.handleGuiInputFromClient(buttonID);
		}
	}
}
