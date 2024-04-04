class Main {
    public static void main(String[] args){
        Chunk chunk = new Chunk();
        chunk.generateChunk();
        for(int i=0;i<16;i++){
            System.out.println();
            for(int j=0;j<16;j++){
                System.out.print(chunk.getSpot(i,j).drawChar());
            }
        }
    }
}