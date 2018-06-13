package myjava.awt.datatransfer;

public interface Transferable {
    Object getTransferData(DataFlavor dataFlavor);

    DataFlavor[] getTransferDataFlavors();

    boolean isDataFlavorSupported(DataFlavor dataFlavor);
}
