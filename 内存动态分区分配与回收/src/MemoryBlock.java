public class MemoryBlock {
    public int size;           //内存块大小
    public int site;           //内存块头地址

    public MemoryBlock(){
    }

    public MemoryBlock(int size, int site){
        this.size = size;
        this.site = site;
    }
}
