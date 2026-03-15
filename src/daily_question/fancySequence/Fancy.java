package daily_question.fancySequence;

import java.util.ArrayList;
import java.util.List;

/// # Fancy Sequence
///
/// An efficient data structure that supports building a sequence of numbers
/// with batch arithmetic operations.
///
/// Instead of applying operations directly to every element (which would be
/// too slow for large inputs), the class maintains a **lazy linear transformation**
/// of the form:
///
/// ```math
/// value = original * mul + add
/// ```
///
/// Where:
///
/// - `mul` represents a global multiplication factor.
/// - `add` represents a global addition factor.
///
/// All operations are performed **modulo 1_000_000_007**.
///
/// ## Supported Operations
///
/// - **append(val)**
///   Adds a new value to the sequence.
///
/// - **addAll(inc)**
///   Adds `inc` to every element in the sequence.
///
/// - **multAll(m)**
///   Multiplies every element in the sequence by `m`.
///
/// - **getIndex(idx)**
///   Returns the value at index `idx` after all transformations.
///
/// ## Key Idea
///
/// Instead of updating all stored elements when `addAll` or `multAll` is called,
/// we store each value **normalized relative to the current transformation**.
/// When retrieving a value, we reapply the accumulated transformation.
///
/// This approach keeps operations efficient even when the sequence becomes large.
///
/// ## Time Complexity
///
/// | Operation | Complexity |
/// |-----------|------------|
/// | append    | O(log MOD) |
/// | addAll    | O(1)       |
/// | multAll   | O(1)       |
/// | getIndex  | O(1)       |
///
/// ## Space Complexity
///
/// ```
/// O(n)
/// ```
///
/// Where `n` is the number of appended values.
///
/// ## Example
///
/// ```java
/// Fancy fancy = new Fancy();
///
/// fancy.append(2);   // [2]
/// fancy.addAll(3);   // [5]
/// fancy.append(7);   // [5,7]
/// fancy.multAll(2);  // [10,14]
///
/// fancy.getIndex(0); // 10
/// ```
class Fancy {

    /// Constant modulus used for all arithmetic operations.
    private static final long MOD = 1_000_000_007;

    /// Stores normalized values of the sequence.
    private List<Long> values;

    /// Global multiplication factor applied to all elements.
    private long mul;

    /// Global addition factor applied to all elements.
    private long add;

    /// Creates an empty Fancy sequence.
    ///
    /// The initial transformation is the identity:
    ///
    /// ```math
    /// value = original * 1 + 0
    /// ```
    public Fancy() {
        values = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    /// Appends a new value to the sequence.
    ///
    /// The value is **normalized** relative to the current transformation
    /// so future operations remain correct.
    ///
    /// ### Steps
    ///
    /// 1. Reverse the current transformation.
    /// 2. Store the normalized value.
    ///
    /// ### Parameters
    ///
    /// - `val` — the value to append.
    public void append(int val) {
        long invMul = modInverse(mul);
        long normalized = ((val - add) % MOD + MOD) % MOD;
        normalized = (normalized * invMul) % MOD;
        values.add(normalized);
    }

    /// Adds a constant value to all elements in the sequence.
    ///
    /// This operation updates only the **global addition factor**.
    ///
    /// ### Parameters
    ///
    /// - `inc` — value to add to every element.
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    /// Multiplies all elements in the sequence by `m`.
    ///
    /// This updates both transformation parameters:
    ///
    /// ```math
    /// mul = mul * m
    /// add = add * m
    /// ```
    ///
    /// ### Parameters
    ///
    /// - `m` — multiplier applied to all elements.
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    /// Retrieves the value at the specified index after applying
    /// all transformations.
    ///
    /// ### Parameters
    ///
    /// - `idx` — the index to retrieve (0-based).
    ///
    /// ### Returns
    ///
    /// - The transformed value modulo `1_000_000_007`.
    /// - `-1` if the index is out of bounds.
    public int getIndex(int idx) {
        if (idx >= values.size()) return -1;

        long val = values.get(idx);
        long result = (val * mul + add) % MOD;
        return (int) result;
    }

    /// Computes the **modular multiplicative inverse** of a number
    /// using Fermat's Little Theorem.
    ///
    /// ```math
    /// x^{-1} ≡ x^{MOD-2} (mod MOD)
    /// ```
    ///
    /// ### Parameters
    ///
    /// - `x` — number whose inverse will be calculated.
    ///
    /// ### Returns
    ///
    /// The modular inverse of `x`.
    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    /// Computes modular exponentiation using **binary exponentiation**.
    ///
    /// ### Parameters
    ///
    /// - `base` — the base value.
    /// - `exp` — exponent.
    ///
    /// ### Returns
    ///
    /// ```math
    /// base^{exp} mod MOD
    /// ```
    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}