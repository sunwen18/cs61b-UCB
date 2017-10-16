import java.lang.Math;
public class Planet {
	public double xxPos,yyPos, xxVel,yyVel,mass;
	public String imgFileName;
	public static double G=6.67e-11;

	public Planet(double xP,double yP,double xV,
	               double yV,double m,String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
	}
    public double calcDistance(Planet p){
    	double r;
		r=Math.sqrt((p.xxPos-xxPos)*(p.xxPos-xxPos)+(p.yyPos-yyPos)*(p.yyPos-yyPos));
        return r;
    }
    public double calcForceExertedBy(Planet p){
    	double F;
    	F=G*mass*p.mass/Math.pow(this.calcDistance(p),2);
    	return F;
    }
	public double calcForceExertedByX(Planet p){
		double Fx;
		Fx=this.calcForceExertedBy(p)*(p.xxPos-xxPos)/this.calcDistance(p);
		return Fx;
	}
	public double calcForceExertedByY(Planet p){
        double Fy;
        Fy=this.calcForceExertedBy(p)*(p.yyPos-yyPos)/this.calcDistance(p);
		return Fy;
	}
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double Fxx=0;
		int i=allPlanets.length;
		for (int j=0;j<i;j++){
			if (this!=allPlanets[j]){
				Fxx += this.calcForceExertedByX(allPlanets[j]);
			}
			
		}
		return Fxx;

	}
    public double calcNetForceExertedByY(Planet[] allPlanets){
    	double Fyy=0;
		int i=allPlanets.length;
		for (int j=0;j<i;j++){
			if (this!=allPlanets[j]){
				Fyy += this.calcForceExertedByY(allPlanets[j]);
		    }
		}
		return Fyy;

    }
    public void update(double dt,double Fx,double Fy){
    	double ax,ay;
    	ax=Fx/mass;
    	ay=Fy/mass;
    	xxVel+=dt*ax;
    	yyVel+=dt*ay;
    	xxPos+=xxVel*dt;
    	yyPos+=yyVel*dt;
    }
    public void draw(){
    	StdDraw.picture(xxPos, yyPos, imgFileName);
		

    }


}
