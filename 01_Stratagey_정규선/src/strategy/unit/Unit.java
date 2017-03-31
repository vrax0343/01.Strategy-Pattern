package strategy.unit;

import strategy.behavior.attack.AttackBehavior;
import strategy.behavior.movement.MovementBehavior;
import strategy.behavior.weapon.WeaponBehavior;
import strategy.check.MapLimitCheck;
import strategy.function.GenerateRandomPosition;

public abstract class Unit {
	AttackBehavior attack = null;
	MovementBehavior movement = null;
	WeaponBehavior weapon=null;
	
	String type = "";
	int locationX=0, locationY=0;
	int health=0;
	int movementSpeed=0;
	
	Unit() { }
	Unit(String type){
		this.type=type;
		this.locationX=GenerateRandomPosition.generate();
		this.locationY=GenerateRandomPosition.generate();
	}
	
	public abstract void fight();
	
	public void move(int x, int y){
		MapLimitCheck mlc = new MapLimitCheck();
		int tempX=this.locationX, tempY=this.locationY;
		tempX += x; tempY += y;
		this.setLocation(mlc.check(tempX), mlc.check(tempY));
		System.out.print(this.type+"��\t ");
		System.out.println(movement.getMovementType() +"�� �̵��մϴ�.");
	}
	
	
	
	
	//getter
	public String getType(){
		return this.type;
	}
	public void getLocation(){
		System.out.println("("+this.locationX+"," + this.locationY+")");
	}
	public int getLocationX(){
		return this.locationX;
	}
	public int getLocationY(){
		return this.locationY;
	}
	public String getWeaponType(){
		return this.weapon.getWeaponType();
	}	
	public String getAttackType(){
		return this.attack.getAttackType();
	}
	
	
	//setter
	public void setWeapon(WeaponBehavior w){
		System.out.print("[Before Weapon]: " + this.getWeaponType() +"\t");
		this.weapon = w;
		System.out.println("[After Weapon]: " + this.getWeaponType());
	}
	public void setMovement(MovementBehavior m){
		this.movement = m;
	}
	public void setAttack(AttackBehavior a){
		System.out.print("[Before Attack]: " + this.getAttackType() +"\t");
		this.attack = a;
		System.out.println("[After Attack]: " + this.getAttackType());
	}
	
	public void setLocation(int x, int y){
		System.out.print("[Before Location]: (" + this.getLocationX()+","+this.getLocationY()+")\t");
		this.locationX = x;
		this.locationY = y;
		System.out.println("[After Location]: (" + this.getLocationX()+","+this.getLocationY()+")");
		System.out.println();
	}
	
	
	//toString
	public String toString(){
		return "---���� "+this.type+"�� �����Դϴ�---" + "\n"+ 
				"Type: " + this.type + "\t"+
				"Health: " + this.health + "\t"+
				"Location X,Y: " + this.locationX+","+this.locationY+"\t"+
				"WeaponType: " + this.weapon.getWeaponType() + "\t"+
				"MovementType: " + this.movement.getMovementType() + "\t"+
				"AttackType: " + this.attack.getAttackType() + "\t";
	}
}
