package core;

public class Table {

    int tableId;
    boolean isFree;

    public Table(int tableId, boolean isFree) {
        this.tableId = tableId;
        this.isFree = isFree;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }



    @Override
    public String toString() {
        return "Table{" +
               "tableId=" + tableId +
               '}';
    }
}
