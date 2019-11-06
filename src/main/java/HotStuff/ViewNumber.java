package HotStuff;

public class ViewNumber {
    long viewNumber;

    public ViewNumber(long _viewNumber) {
        viewNumber = _viewNumber;
    }

    @Override
    public String toString() {
        return Long.toString(viewNumber);
    }
}
