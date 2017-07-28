package mydefault;
/**
 * <exp> ::= <int>|(<exp> + <exp>)|(<exp>-<exp>)|(<exp>*<exp>)|(<exp>/<exp>)
 * 
 * @author Leo
 *
 */
public abstract class Expression {

	public static Expression add(Expression l, Expression r){
		return  SimpleFactory.createAdd(l, r);
	}
	public static Expression lit(int b){
		return SimpleFactory.createLit(b);
	}
	public static Expression mult(Expression l, Expression r){
		return  SimpleFactory.createMulti(l, r);
	}
	public static Expression subt(Expression l, Expression r){
		return  SimpleFactory.createSubt(l, r);
	}
	public static Expression div(Expression l, Expression r){
		return  SimpleFactory.createDivd(l, r);
	}
	public static Expression var(String b){
		return SimpleFactory.createVar(b);
	}
		public abstract String show();
		
		public abstract int evaculate(Mappings m);
		
		public abstract int size();
		
		public abstract int height();
		
		public abstract int operators();
		
		public abstract Expression simplify(Mappings m);
		
		public static Expression parseExp(Tokenizer tok) {
//			System.out.println("re");

			if (tok.current() instanceof Integer) {
				Expression e = new LitExp((Integer)tok.current());
//				if (tok.hasNext()){
//					exp1 = current;
//					tok.next();
//					exp2 = parseExp(tok);
//					return exp2;
//				}
				tok.next();
				return e;
			} else if (tok.current().equals("(")) {
//				tok.next();
//				tok.parse("("); 
//				Expression exp1 = parseExp(tok);
//				tok.parse(",");
//				Expression exp2= parseExp(tok);
//				Expression e = add(exp1,exp2);
//				tok.parse(")");
				Expression e = lit(0);
				String operator = ""; 
				tok.next();
				Expression exp1 = parseExp(tok);
				if (tok.current().equals("+")){
					operator = "add";
				}else if(tok.current().equals("-")){
					operator = "sub";
				}else if(tok.current().equals("*")){
					operator = "mul";
				}else if(tok.current().equals("/")){
					operator = "div";
				}
				tok.next();
				Expression exp2 = parseExp(tok);

				if (operator.equals("add")){
					e = add(exp1,exp2);
				}else if(operator.equals("sub")){
					e = subt(exp1,exp2);
				}else if(operator.equals("mul")){
					e = mult(exp1,exp2);
				}else if(operator.equals("div")){
					e = div(exp1,exp2);
				}
				tok.parse(")");
				return e;
			} 
//			else if(tok.current().equals("sub")){
//				tok.next();
//				tok.parse("("); 
//				Expression exp1 = parseExp(tok);
//				tok.parse(",");
//				Expression exp2= parseExp(tok);
//				Expression e = subt(exp1,exp2);
//				tok.parse(")");
//				return e;
//			}else if(tok.current().equals("mult")){
//				tok.next();
//				tok.parse("("); 
//				Expression exp1 = parseExp(tok);
//				tok.parse(",");
//				Expression exp2= parseExp(tok);
//				Expression e = mult(exp1,exp2);
//				tok.parse(")");
//				return e;
//			}else if(tok.current().equals("div")){
//				tok.next();
//				tok.parse("("); 
//				Expression exp1 = parseExp(tok);
//				tok.parse(",");
//				Expression exp2= parseExp(tok);
//				Expression e = div(exp1,exp2);
//				tok.parse(")");
//				return e;
//			}else if(tok.current().equals("\n")){
//				return null;
//			}
			throw new Error();
		}
		
}