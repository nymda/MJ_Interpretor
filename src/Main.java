import java.util.Map;

public enum vType {
    bool,
    numeric,
    add,
}

public enum associative{
    leftAssociative,
    rightAssociative
}

public interface Expr {
    Object getLeft();
    Object getRight();
    void setLeft(Object left);
    void setRight(Object right);
    Object interp();
    int getPrecedence();
    associative getAssociative();
}

public static class NumberLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 0;
    public final associative assoc = associative.leftAssociative;

    private final float value;
    public NumberLit(float value) { this.value = value; }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return value;
    }

    @Override
    public String toString(){
        return Float.toString(this.value);
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class BooleanLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 0;
    public final associative assoc = associative.leftAssociative;

    private final boolean value;
    public BooleanLit(boolean value) { this.value = value; }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return value;
    }

    @Override
    public String toString(){
        return Boolean.toString(this.value);
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class AddLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 3;
    public final associative assoc = associative.leftAssociative;

    public AddLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (float)((Expr)this.getLeft()).interp() + (float)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "+";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class SubLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 3;
    public final associative assoc = associative.leftAssociative;

    public SubLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (float)((Expr)this.getLeft()).interp() - (float)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "-";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class MulLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 4;
    public final associative assoc = associative.leftAssociative;

    public MulLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (float)((Expr)this.getLeft()).interp() * (float)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "*";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class DivLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 4;
    public final associative assoc = associative.leftAssociative;

    public DivLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (float)((Expr)this.getLeft()).interp() / (float)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "/";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class ExpLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 4;
    public final associative assoc = associative.rightAssociative;

    public ExpLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (int)((Expr)this.getLeft()).interp() ^ (int)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "^";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class GtLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 2;
    public final associative assoc = associative.leftAssociative;

    public GtLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (float)((Expr)this.getLeft()).interp() > (float)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "GreaterThan";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class LtLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 2;
    public final associative assoc = associative.leftAssociative;

    public LtLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (float)((Expr)this.getLeft()).interp() < (float)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "LessThan";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class OrLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 1;
    public final associative assoc = associative.leftAssociative;

    public OrLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (boolean)((Expr)this.getLeft()).interp() || (boolean)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "LogicalOr";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class AndLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 1;
    public final associative assoc = associative.leftAssociative;

    public AndLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        return (boolean)((Expr)this.getLeft()).interp() && (boolean)((Expr)this.getRight()).interp();
    }

    @Override
    public String toString(){
        return "LogicalAnd";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class EquLit implements Expr {
    private Object Left;
    private Object Right;
    public final int precedence = 1;
    public final associative assoc = associative.leftAssociative;

    public EquLit(){ }

    @Override
    public Object getLeft(){
        return this.Left;
    }

    @Override
    public Object getRight(){
        return this.Right;
    }

    @Override
    public void setLeft(Object left) {
        this.Left = left;
    }

    @Override
    public void setRight(Object right){
        this.Right = right;
    }

    @Override
    public Object interp(){
        Object l = ((Expr)this.getLeft()).interp();
        Object r = ((Expr)this.getRight()).interp();

        if(l instanceof Float && r instanceof Float){
            return (float)((Expr)this.getLeft()).interp() == (float)((Expr)this.getRight()).interp();
        }
        if(l instanceof Boolean && r  instanceof Boolean){
            return (boolean)((Expr)this.getLeft()).interp() == (boolean)((Expr)this.getRight()).interp();
        }
        throw new RuntimeException("Type mismatch in equal");
    }

    @Override
    public String toString(){
        return "LogicalEqual";
    }

    @Override
    public int getPrecedence(){
        return this.precedence;
    }

    @Override
    public associative getAssociative(){
        return this.assoc;
    }
}

public static class Context{

    public List<Expr> processString(String expression){
        List<Expr> response = new LinkedList<>();
        StringBuilder digits = new StringBuilder();
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c) || c == '.' || c == '_'){
                if(c == '_'){ c = '-'; }
                digits.append(c);
            }
            else{
                if(!digits.isEmpty()){
                    response.add(new NumberLit(Float.parseFloat(digits.toString())));
                    digits = new StringBuilder();
                }
                switch (c){
                    case 'T':
                        response.add(new BooleanLit(true));
                        break;
                    case 'F':
                        response.add(new BooleanLit(false));
                        break;
                    case '+':
                        response.add(new AddLit());
                        break;
                    case '-':
                        response.add(new SubLit());
                        break;
                    case '*':
                        response.add(new MulLit());
                        break;
                    case '/':
                        response.add(new DivLit());
                        break;
                    case '^':
                        response.add(new ExpLit());
                        break;
                    case '>':
                        response.add(new GtLit());
                        break;
                    case '<':
                        response.add(new LtLit());
                        break;
                    case '|':
                        response.add(new OrLit());
                        break;
                    case '&':
                        response.add(new AndLit());
                        break;
                    case '=':
                        response.add(new EquLit());
                        break;
                }
            }
        }
        if(!digits.isEmpty()){
            response.add(new NumberLit(Float.parseFloat(digits.toString())));
        }
        return response;
    }

    public List<Expr> shunt(List<Expr> expressions){
        Queue<Expr> queue = new LinkedList<>();
        Stack<Expr> stack = new Stack<>();
        List<Expr> response = new LinkedList<>();
        for(Expr o : expressions){
            if(o instanceof NumberLit || o instanceof BooleanLit){
                queue.add(o);
            }
            else{
                while(!stack.isEmpty()){
                    Expr top = ((Expr)stack.peek());
                    if(top.getPrecedence() > o.getPrecedence() || (top.getPrecedence() == o.getPrecedence() && o.getAssociative() == associative.leftAssociative)){
                        queue.add(stack.pop());
                    }
                    else{
                        break;
                    }
                }
                stack.push(o);
            }
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        return new ArrayList<>(queue);
    }

    public Expr buildAST(List<Expr> expressions){
        Stack<Expr> stack = new Stack<>();

        for(Expr o : expressions){
            if(o instanceof NumberLit || o instanceof BooleanLit){
                stack.push(o);
            }
            else{
                Expr right = stack.pop();
                Expr left = stack.pop();
                o.setRight(right);
                o.setLeft(left);
                stack.push(o);
            }
        }
        return stack.pop();
    }

    public Expr evaluate(String expression){
        //process tokens into expressions
        List<Expr> extracted = processString(expression);

        //perform shunting yard to convert to RPN
        List<Expr> RPN = shunt(extracted);

        //convert to AST and return root
        return buildAST(RPN);
    }

    public Context() {

    }
}

void main() {
    Context c = new Context();
    System.out.println(c.evaluate("_100<5|T").interp());
}