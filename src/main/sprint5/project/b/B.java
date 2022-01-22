package main.sprint5.project.b;

/**
 -- ПРИНЦИП РАБОТЫ --

 При наивном удалении вершины в дереве мы можем нарушить целостность дерева.

 У вершины в бинарном дереве может быть до трёх рёбер (одно — от родителя к вершине и два —
 от вершины к детям). Соответственно, она может объединять собой три отдельные группы вершин.
 Удаление такой вершины разорвёт связь между этими группами.

 Чтобы этого избежать, надо соединить распавшиеся поддеревья новыми рёбрами.

 Для того чтобы дерево осталось деревом поиска, на место удалённой вершины надо поставить какую-то
 другую вершину.

 Есть два варианта, как можно восстановить дерево:
 1. Поставить на место удаленной вершины самую правую вершину в левом поддереве.
    Там лежит самое большое значение из левого поддерева, и оно точно меньше, чем любое значение
    правого поддерева.
 2. Поставить на место удаленной вершины самую левую вершину в правом поддереве.
    Там лежит самое маленькое значение из правого поддерева, и оно точно не меньше, чем любое
    значение левого поддерева.

 В нашем случае, мы всегда будем брать самую правую вершину в левом поддереве.

 Алгоритм действий в нашей функции по удалению узла из дерева:
 1. Проверяем, что узел не равен null, иначе возвращаем null
 2. Далее, нам нужно найти узел, который необходимо удалить. Ищем также, как если бы искали в
    бинарном дереве - если ключ меньше ключа корня - то ищем в левом поддере, если больше - то в правом
    поддереве.
 3. Если мы нашли необходимый узел, то нам нужно произвести следующие действия:
      1) Проверить, если левый ребенок удаляемой вершины отсутствует, то мы можем безопасно поставить
        правого ребенка на место удаляемой вершины
      2) Проверить, если правый ребенок удаляемой вершины отсутствует, то мы можем безопасно поставить
        левого ребенка на место удаляемой вершины
      3) Иначе нам нужно найти преемника, в нашем случае это будет самая правая вершина в левом поддереве.
        Помимо того, у преемника также может быть левый ребенок (правого не может быть, т.к. мы и так
        нашли самую правую вершину). Чтобы не оставить преемника осиротевшим после переноса, нам
        нужно будет на его место поставить его левого ребенка

 После выполнения всех вышеописанных действий, дерево останется в корректной форме

 -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 Данный алгоритм корректно работает, т.к. мы не позволяем при удалении узла распасться дереву на
 несколько поддеревьев, восстанавливая его в правильном порядке

 -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 Временная сложность данного алгоритма составляет O(h), где h - высота дерева

 -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 Пространственная сложность данного алгоритма составляет O(logN)
 */

//63243346
public class B {

  public static Node remove(Node root, int key) {
    if (root == null) {
      return null;
    }

    if (key < root.getValue()) {
      root.setLeft(remove(root.getLeft(), key));
    } else if (key > root.getValue()) {
      root.setRight(remove(root.getRight(), key));
    } else {
      if (root.getLeft() == null) {
        return root.getRight();
      } else if (root.getRight() == null) {
        return root.getLeft();
      } else {
        root.setValue(successor(root));
        root.setLeft(remove(root.getLeft(), root.getValue()));
      }
    }

    return root;
  }

  private static int successor(Node root) {
    root = root.getLeft();

    while (root.getRight() != null) {
      root = root.getRight();
    }

    return root.getValue();
  }

  private static class Node {

    private int value;
    private Node left;
    private Node right;

    Node(Node left, Node right, int value) {
      this.left = left;
      this.right = right;
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setValue(int value) {
      this.value = value;
    }

  }

  private static void test() {
    Node node1 = new Node(null, null, 2);
    Node node2 = new Node(node1, null, 3);
    Node node3 = new Node(null, node2, 1);
    Node node4 = new Node(null, null, 6);
    Node node5 = new Node(node4, null, 8);
    Node node6 = new Node(node5, null, 10);
    Node node7 = new Node(node3, node6, 5);
    Node newHead = remove(node7, 10);
    assert newHead.getValue() == 5;
    assert newHead.getRight() == node5;
    assert newHead.getRight().getValue() == 8;
  }

}