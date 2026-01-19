package leetcode_beginners_guide.richestCustomerWealth;

/// # Status Class.
/// The `Status` class holds the status of a system operation as an `int`.
/// It is used in conjunction with the `example_01_jep455` class to demonstrate
/// the new `switch` features introduced in **JEP 455**.
/// ## Fields
/// - `status`: an integer representing the status of the operation.
/// ## Constructor
/// ```java
/// Status status = new Status(0);
/// ```
/// ### Parameters
/// - `status`: an `int` representing the system's current status.
class Status {
    private final int status;

    public Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
