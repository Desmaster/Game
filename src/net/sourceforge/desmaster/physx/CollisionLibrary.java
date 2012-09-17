package net.sourceforge.desmaster.physx;

public class CollisionLibrary {

	public static boolean testAABBAABB(final AABB box1, final AABB box2) {
		if (Math.abs(box1.center.x - box2.center.x) > (box1.r[0] + box2.r[0])) return false;
		if (Math.abs(box1.center.y - box2.center.y) > (box1.r[1] + box2.r[1])) return false;
		return true;
	}
	
	public static boolean testCircleCircle(final Circle c1, final Circle c2) {
		final float distSQ = c1.center.distSQ(c2.center);
		final float radiusSum = c1.radius + c2.radius;
		return distSQ <= radiusSum * radiusSum;
	}
	
	public static float sqDistPointAABB(final Vector p, final AABB aabb) {
		float sqDist = 0.0f;
		float v;
		float minX, minY, maxX, maxY;
		
		minX = aabb.center.x - aabb.r[0];
		maxX = aabb.center.x + aabb.r[0];
		
		minY = aabb.center.y - aabb.r[1];
		maxY = aabb.center.y + aabb.r[1];
		
		v = p.x;
		
		if (v < minX) sqDist += (minX - v) * (minX - v);
		if (v > maxX) sqDist += (v - maxX) * (v - maxX);
		
		v = p.y;
		
		if (v < minY) sqDist += (minY - v) * (minY - v);
		if (v > maxY) sqDist += (v - maxY) * (v - maxY);
		return sqDist;
	}

	public static boolean testCircleAABB(final Circle circle, final AABB box) {
		float sqDist = sqDistPointAABB(circle.center, box);
		float r = circle.radius;
		System.out.println(sqDist);
		System.out.println(r * r);
		return sqDist >= r * r;
	}
	
}
