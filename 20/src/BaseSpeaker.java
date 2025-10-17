public abstract class BaseSpeaker implements ITelephoneSpeaker{
    protected int volume;
    protected boolean isMuted;

    @Override
    public boolean mute() {
        isMuted = true;
        return true;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getVolume() {
        return volume;
    }
}
