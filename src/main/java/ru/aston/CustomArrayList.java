package ru.aston;

/**
 * Класс, реализующий хранение данных любого типа в виде списка.
 * Предоставляет методы для выполнения операций с этим списком
 */
public class CustomArrayList<T> {
    /**
     * Изначальная вместимость списка
     */
    private static final int CAPACITY = 10;
    /**
     * Коэффициент увеличения списка при его полном заполнении
     */
    private static final double KOEF = 1.5;
    /**
     * Массив, в котором хранятся объекты
     */
    private Object[] elements;
    /**
     * Кол-во объектов, хранящихся в списке
     */
    private int size;

    /**
     * Конструктор без параметров для создания списка
     */
    public CustomArrayList() {
        elements = new Object[CAPACITY];
    }

    /**
     * Конструктор с параметром для создания списка
     * @param capacity изначальная вместимость списка
     */
    public CustomArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Некорректный размер массива");
        }
        elements = new Object[capacity];
    }

    /**
     * Добавляет новый объект в список
     * @param element добавляемый объект любого типа
     */
    public void add(T element) {
        autoIncrease();
        elements[size++] = element;
    }

    /**
     * Добавляет новый объект в список в определенное место
     * @param index определяет место в списке, в которое добавляется объект
     * @param element добавляемый объект любого типа
     */
    public void add(int index, T element) {
        validateIndex(index);
        autoIncrease();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Заменяет элемент, расположенный в списке под определенным номером, на новый
     * @param index порядковый номер заменяемого объекта
     * @param element новый объект
     */
    public void set(int index, T element) {
        validateIndex(index);
        elements[index] = element;
    }

    /**
     * Получение объекта по его порядковому номеру в списке
     * @param index порядковый номер получаемого объекта
     * @return объект, хранящийся под указанным порядковым номером
     */
    public T get(int index) {
        validateIndex(index);
        return (T) elements[index];
    }

    /**
     * Удаление обхекта из списка по его порядковому номеру
     * @param index порядковый номер удаляемого объекта
     */
    public void remove(int index) {
        validateIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Удаление всех объектов из списка
     */
    public void removeAll() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Получение кол-ва объектов, хранящихся в списке
     * @return кол-во объектов в списке
     */
    public int size() {
        return size;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index некорректен");
        }
    }

    private void autoIncrease() {
        if (size == elements.length) {
            Object[] newElements = new Object[(int) (elements.length * KOEF)];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
}
