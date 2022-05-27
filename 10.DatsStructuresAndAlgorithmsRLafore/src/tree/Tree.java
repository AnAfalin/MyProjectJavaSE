package tree;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;           //корень
    int size;                       //размер дерева

    public Tree() {
    }

    class Node<T> {
        T key;                      //значение элемента
        Node<T> leftChild;          //Левый потомок узла
        Node<T> rightChild;         //Правый потомок узла

        public Node(T key) {
            this.key = key;
        }
    }

    public void add(T key) {
        Node<T> newNode = new Node<>(key);
        if (root == null) {                   //Корневой узел не существует
            root = newNode;
            size++;
            return;
        }

        Node<T> current = root;                     //Начало прохождения с корневого узла
        Node<T> parent;                             //Родитель - это родитель текущего узла
        while (true) {
            parent = current;
            if (key.compareTo(current.key) < 0) {   //Если искомое значение меньше значения текущего узла
                current = current.leftChild;        //то текущий элемент - левый потомок
                if (current == null) {              //если достигнут конец цепочки
                    parent.leftChild = newNode;     //вставляем слева
                    size++;
                    return;
                }
            } else {                                //Если искомое значение НЕ меньше значения текущего узла, т.е. больше
                current = current.rightChild;       //то текущий элемент - правый потомок
                if (current == null) {              //если достигнут конец цепочки
                    parent.rightChild = newNode;    //вставляем справа
                    size++;
                    return;
                }
            }
        }
    }

    public Node<T> minimum(){
        if(root == null){
            return null;
        }
        Node<T> current = root;
        Node<T> last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node<T> maximum(){
        if(root == null){
            return null;
        }
        Node<T> current = root;
        Node<T> last = current;
        while (current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(T key){
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeftChild = true;

        //поиск удаляемого узола
        while (key.compareTo(current.key) != 0){
            parent = current;
            if(key.compareTo(current.key) < 0) {
                isLeftChild = true;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){        //конец цепочки
                return false;           //удаляемый узел не найден
            }
        }

        //если узел не имеет потомков, он просто удаляется
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){            //Если узел является корневым
                root = null;                //дерево очищается
            }else if(isLeftChild){
                parent.leftChild = null;    //отсоединения узла от родителя
            }else {
                parent.rightChild = null;   //отсоединения узла от родителя
            }
        }

        //удаляемый узел имеет один потомок
        //если нет правого потомка, узел заменяется левым поддеревом
        else if(current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        }
        //если нет левого потомка, узел заменяется правым поддеревом
        else if(current.leftChild == null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
        }

        //удаляемый узел имеет двух потомков
        else {
            //Поиск преемника для удаляемого узла current
            Node<T> successor = getSuccessor(current);

            //Родитель связывается с посредником
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            //Преемник связывается с левым потомком current
            successor.leftChild = current.leftChild;
        }
        return true;



    }

    private Node<T> getSuccessor(Node<T> delNode){
        Node<T> successorParent = delNode;
        Node<T> successor = delNode;
        Node<T> current = delNode.rightChild;      //Переход к правому потомку
        while (current != null){                   //Пока остаются левые потомки
            successorParent = successor;
            successor = current;
            current = current.leftChild;            //Переход к левому потомку
        }

        if(successor != delNode.rightChild){       //Если преемник не является правм потомком, то создаем связи между узлами
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void print(){
        inOrder(root);
    }

    private void inOrder(Node<T> localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);

            System.out.println(localRoot.key + " ");

            inOrder(localRoot.rightChild);
        }
    }

    @SuppressWarnings("unchecked")
    public Node<T> find(T key) {
        Node<T> current = root;                         //Начало с корневого узла
        while (current.key != key) {                    //Пока не найдено совпадение

            if (key.compareTo(current.key) < 0) {       //Если искомое значение меньше проходимого узла
                current = current.leftChild;            //то двигаемся налево
            } else {                                    //иначе
                current = current.rightChild;           //двигаемся направо
            }
            if (current == null) {                      //если потомка нет
                return null;
            }

        }
        return current;
    }

}

class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(15);
        tree.add(25);
        tree.add(40);
        tree.add(30);
        tree.delete(25);
        tree.print();
    }
}