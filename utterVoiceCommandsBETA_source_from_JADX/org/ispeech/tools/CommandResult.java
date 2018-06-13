package org.ispeech.tools;

public class CommandResult {
    public CommandType Command;
    public byte[] Data;
    private String[] param = new String[0];
    public String uniqueId;

    public enum CommandType {
        UNKNOWN(0),
        COMMAND_SEND_SMS(1),
        COMMAND_PHONE_CALL(2),
        COMMAND_LAUNCH_URL(3);
        
        private int value;

        private CommandType(int i) {
            this.value = i;
        }

        public static CommandType parseInt(int i) {
            return i >= values().length ? UNKNOWN : values()[i];
        }

        public final int getValue() {
            return this.value;
        }
    }

    public CommandResult(CommandType commandType, byte[] bArr) {
        this.Data = bArr;
        this.Command = commandType;
    }

    public void addParameter(byte[] bArr) {
        int length = this.param.length + 1;
        String[] strArr = new String[length];
        for (int i = 0; i < length - 1; i++) {
            strArr[i] = this.param[i];
        }
        strArr[length - 1] = new String(bArr);
        this.param = strArr;
    }

    public String getParameter(int i) {
        return (this.param == null || this.param.length < i) ? null : this.param[i];
    }

    public int getParameterCount() {
        return (this.param == null || this.param.length <= 0) ? 0 : this.param.length;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }
}
