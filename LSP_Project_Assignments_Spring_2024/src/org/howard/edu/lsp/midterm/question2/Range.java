package org.howard.edu.lsp.midterm.question2;

public interface Range {
	// Returns true if v is ≥ lower bound and ≤ upper bound and false otherwise
    public boolean contains( int value ); 
    
    // Returns true if the receiver contains at least 
    // one value in common with other, and false otherwise
    public boolean overlaps( Range other );
    
    // // Returns the number of integers in the range
    public int size(); 
}

class IntegerRange implements Range {
    private int lowerBound;
    private int upperBound;

    public IntegerRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
    }

    @Override
    public boolean overlaps(Range other) {
        return (other.contains(lowerBound) || other.contains(upperBound)) ||
                (contains(((IntegerRange) other).lowerBound) || contains(((IntegerRange) other).upperBound));
    }

    @Override
    public int size() {
        return Math.abs(upperBound - lowerBound) + 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        IntegerRange other = (IntegerRange) obj;
        return lowerBound == other.lowerBound && upperBound == other.upperBound;
    }
}

class RangeTester {
    public static void main(String[] args) {
        // Test IntegerRange
        IntegerRange range1 = new IntegerRange(5, 10);
        IntegerRange range2 = new IntegerRange(8, 15);
        IntegerRange range3 = new IntegerRange(1, 3);
        
        System.out.println("Range 1 contains 7: " + range1.contains(7));
        System.out.println("Range 1 overlaps with range 2: " + range1.overlaps(range2));
        System.out.println("Range 1 size: " + range1.size());
        System.out.println("Range 1 equals range 2: " + range1.equals(range2));
        System.out.println("Range 1 equals range 3: " + range1.equals(range3));
    }
}




