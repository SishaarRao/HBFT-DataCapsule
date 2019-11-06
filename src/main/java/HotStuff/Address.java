package HotStuff;

/**
 * Represents an Address of a particular DataCapsule. Encapsulates all information needed
 * for network communication
 */
public class Address {
    private int address;

    public Address (int _address) {
        address = _address;
    }

    public int getAddress() {
        return address;
    }
}
