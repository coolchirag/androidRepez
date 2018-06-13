package org.ispeech.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class SerializableHashTable {
    private Hashtable<String, byte[]> _h = new Hashtable();

    public static SerializableHashTable deserialize(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readInt = dataInputStream.readInt();
        SerializableHashTable serializableHashTable = new SerializableHashTable();
        if (bArr.length - 4 != readInt) {
            return null;
        }
        short readShort = dataInputStream.readShort();
        for (short s = (short) 0; s < readShort; s++) {
            byte[] bArr2 = new byte[dataInputStream.readShort()];
            dataInputStream.read(bArr2);
            String str = new String(bArr2, "utf8");
            bArr2 = new byte[dataInputStream.readShort()];
            dataInputStream.read(bArr2);
            serializableHashTable.put(str, bArr2);
        }
        return serializableHashTable;
    }

    public boolean containsKey(String str) {
        return this._h.containsKey(str);
    }

    public byte[] getBytes(String str) {
        return (byte[]) this._h.get(str);
    }

    public String getString(String str) {
        try {
            return new String(getBytes(str), "utf8");
        } catch (Exception e) {
            return null;
        }
    }

    public Object put(String str, String str2) {
        try {
            return this._h.put(str, str2.getBytes("utf8"));
        } catch (Exception e) {
            return null;
        }
    }

    public Object put(String str, byte[] bArr) {
        return this._h.put(str, bArr);
    }

    public byte[] serialize() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Vector vector = new Vector();
        int i = 0;
        for (String str : this._h.keySet()) {
            byte[] bytes = getBytes(str);
            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
            dataOutputStream2.writeShort(str.length());
            dataOutputStream2.write(str.getBytes("utf8"));
            dataOutputStream2.writeShort(bytes.length);
            dataOutputStream2.write(bytes);
            Object toByteArray = byteArrayOutputStream2.toByteArray();
            vector.addElement(toByteArray);
            dataOutputStream2.close();
            byteArrayOutputStream2.close();
            i = toByteArray.length + i;
        }
        dataOutputStream.writeInt(i + 2);
        dataOutputStream.writeShort(this._h.size());
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            dataOutputStream.write((byte[]) it.next());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int size() {
        return this._h.size();
    }
}
