package ua.com.nix.array;

public class ArrayList<E>
{
    private Object[] array;
    private int size;

    public ArrayList()
    {
        this(10);
    }

    public ArrayList(int n)
    {
        if (n <= 0)
        {
            System.out.println("Incorrect size");
            return;
        }
        this.array = new Object[n];
        this.size = 0;
    }

    public void add(E value)
    {
        if (checkIfArrFull())
            copyArr(0, 2);
        this.array[this.size] = value;
        this.size++;
    }

    public E get(int index)
    {
        return (index >= 0 && index < this.size) ? (E) this.array[index] : null;
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void remove(E value)
    {
        for (int i = 0; i < this.size; i++)
        {
            if (value.equals(this.array[i]))
            {
                this.array[i] = null;
                this.size--;
                copyArr(0, 1);
                return;
            }
        }
    }

    private boolean checkIfArrFull()
    {
        return this.array.length == this.size;
    }

    private void copyArr(int size, int action)
    {
        size = incrArrSize(size, action);
        Object[] tempArr = new Object[size];
        int tempElem = 0;

        for (int i = 0; i < this.array.length; i++, tempElem++)
        {
            if (this.array[i] == null)
            {
                tempElem--;
                continue;
            }
            tempArr[tempElem] = this.array[i];
        }
        this.array = tempArr;
    }

    private int incrArrSize(int size, int action)
    {
        if (action == 2)
            size = this.array.length * 2;
        else
            size = this.array.length + size;

        return size;
    }
}
