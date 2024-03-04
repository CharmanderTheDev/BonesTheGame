interface Drug implements Physical {
    public void injested(Entity e);
    public void injected(Entity e);
    public void inhaled(Entity e);
    public void contacted(Entity e);
}