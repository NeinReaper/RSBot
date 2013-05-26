package walking.webWalking;

import java.util.ArrayList;

import org.powerbot.game.api.wrappers.Tile;

public class Database extends ArrayList<DataPath> {
	public Database(){
		loadPaths();
	}
	private void loadPaths(){
		submit(FGUILD_BANK, FGUILD_BANK_1, EDGEVILLE_DRUINS);
	}
	private void submit(DataPath...paths){
		for(DataPath path : paths){
			if(path != null){
				add(path);
			}
		}
	}
	public static final int WILD_BARRIER_ID = 6926;
	
	public static final DataPath FGUILD_BANK = new DataPath(
									new Tile[]{new Tile(2608, 3414, 0), new Tile(2604, 3414, 0), 
									new Tile(2604, 3420, 0),new Tile(2601, 3421, 0),
									new Tile(2599, 3421, 0), new Tile(2597, 3421, 0),
									new Tile(2595, 3421, 0), new Tile(2593, 3421, 0),
									new Tile(2591, 3421, 0), new Tile(2589, 3421, 0),
									new Tile(2587, 3421, 0), new Tile(2585, 3421, 0)}),
									FGUILD_BANK_1 = new DataPath(new Tile[]{
									new Tile(2603, 3412,0), new Tile(2603, 3409,0),
									new Tile(2603, 3406, 0), new Tile(2603, 3403, 0),
									new Tile(2602, 3403, 0), new Tile(2599, 3403, 0),
									new Tile(2597, 3404, 0), new Tile(2597, 3407, 0),
									new Tile(2597, 3410, 0), new Tile(2597, 3413, 0),
									new Tile(2594, 3413, 0), new Tile(2593, 3415, 0),
									new Tile(2591, 3419, 0), new Tile(2589, 3421, 0),
									new Tile(2586, 3422, 0)}),
									EDGEVILLE_DRUINS = new DataPath(new Tile[] {
									new Tile(3093, 3495, 0), new Tile(3092, 3498, 0),
									new Tile(3091, 3501, 0), new Tile(3089, 3504, 0),
									new Tile(3087, 3507, 0), new Tile(3087, 3510, 0),
									new Tile(3086, 3513, 0), new Tile(3086, 3516, 0),
									new Tile(3086, 3519, 0), new Tile(3086, 3522, 0),
									new Tile(3086, 3525, 0), new Tile(3086, 3528, 0),
									new Tile(3088, 3531, 0), new Tile(3090, 3534, 0),
									new Tile(3091, 3537, 0), new Tile(3092, 3541, 0),
									new Tile(3093, 3544, 0), new Tile(3094, 3547, 0),
									new Tile(3095, 3550, 0), new Tile(3096, 3553, 0),
									new Tile(3097, 3556, 0), new Tile(3099, 3559, 0),
									new Tile(3100, 3562, 0), new Tile(3100, 3565, 0),
									new Tile(3101, 3568, 0), new Tile(3101, 3571, 0),
									new Tile(3101, 3574, 0), new Tile(3102, 3577, 0),
									new Tile(3104, 3580, 0), new Tile(3105, 3583, 0),
									new Tile(3107, 3586, 0), new Tile(3108, 3589, 0),
									new Tile(3111, 3591, 0), new Tile(3112, 3594, 0),
									new Tile(3115, 3597, 0), new Tile(3116, 3600, 0),
									new Tile(3118, 3603, 0), new Tile(3120, 3606, 0),
									new Tile(3123, 3608, 0), new Tile(3125, 3611, 0),
									new Tile(3127, 3614, 0), new Tile(3130, 3616, 0),
									new Tile(3131, 3619, 0), new Tile(3134, 3621, 0),
									new Tile(3137, 3623, 0), new Tile(3139, 3626, 0),
									new Tile(3142, 3629, 0), new Tile(3143, 3632, 0),
									new Tile(3146, 3634, 0), new Tile(3147, 3637, 0),
									new Tile(3149, 3640, 0), new Tile(3151, 3643, 0),
									new Tile(3153, 3646, 0), new Tile(3156, 3649, 0),
									new Tile(3159, 3651, 0), new Tile(3162, 3653, 0),
									new Tile(3165, 3654, 0), new Tile(3168, 3656, 0),
									new Tile(3171, 3658, 0), new Tile(3174, 3660, 0),
									new Tile(3177, 3661, 0), new Tile(3180, 3663, 0),
									new Tile(3183, 3666, 0), new Tile(3186, 3668, 0),
									new Tile(3188, 3671, 0), new Tile(3191, 3673, 0),
									new Tile(3192, 3674, 0), new Tile(3193, 3677, 0),
									new Tile(3193, 3680, 0), new Tile(3194, 3683, 0),
									new Tile(3195, 3686, 0), new Tile(3196, 3689, 0),
									new Tile(3196, 3692, 0), new Tile(3197, 3695, 0),
									new Tile(3197, 3698, 0), new Tile(3197, 3701, 0),
									new Tile(3197, 3704, 0), new Tile(3197, 3707, 0),
									new Tile(3197, 3710, 0), new Tile(3197, 3713, 0),
									new Tile(3197, 3716, 0), new Tile(3197, 3719, 0),
									new Tile(3197, 3722, 0), new Tile(3198, 3725, 0),
									new Tile(3198, 3728, 0), new Tile(3197, 3731, 0),
									new Tile(3197, 3734, 0), new Tile(3197, 3737, 0),
									new Tile(3197, 3740, 0), new Tile(3197, 3743, 0),
									new Tile(3198, 3746, 0), new Tile(3198, 3749, 0),
									new Tile(3199, 3752, 0), new Tile(3201, 3755, 0),
									new Tile(3202, 3758, 0), new Tile(3203, 3761, 0),
									new Tile(3204, 3764, 0), new Tile(3206, 3767, 0),
									new Tile(3208, 3770, 0), new Tile(3210, 3773, 0),
									new Tile(3211, 3776, 0), new Tile(3212, 3779, 0),
									new Tile(3214, 3782, 0), new Tile(3215, 3785, 0),
									new Tile(3217, 3788, 0), new Tile(3219, 3791, 0),
									new Tile(3221, 3794, 0), new Tile(3222, 3797, 0),
									new Tile(3224, 3800, 0), new Tile(3225, 3803, 0),
									new Tile(3228, 3805, 0), new Tile(3230, 3808, 0),
									new Tile(3233, 3810, 0), new Tile(3236, 3812, 0),
									new Tile(3237, 3815, 0), new Tile(3239, 3818, 0),
									new Tile(3240, 3821, 0), new Tile(3242, 3824, 0),
									new Tile(3243, 3827, 0), new Tile(3244, 3830, 0),
									new Tile(3247, 3832, 0), new Tile(3248, 3835, 0),
									new Tile(3249, 3838, 0), new Tile(3252, 3839, 0),
									new Tile(3255, 3841, 0), new Tile(3258, 3842, 0),
									new Tile(3261, 3842, 0), new Tile(3264, 3842, 0),
									new Tile(3267, 3842, 0), new Tile(3270, 3842, 0),
									new Tile(3273, 3842, 0), new Tile(3276, 3842, 0),
									new Tile(3279, 3842, 0), new Tile(3282, 3842, 0),
									new Tile(3285, 3842, 0), new Tile(3288, 3841, 0),
									new Tile(3291, 3841, 0), new Tile(3294, 3841, 0),
									new Tile(3297, 3841, 0), new Tile(3300, 3840, 0),
									new Tile(3302, 3840, 0), new Tile(3305, 3841, 0),
									new Tile(3308, 3842, 0), new Tile(3311, 3842, 0),
									new Tile(3314, 3842, 0), new Tile(3317, 3843, 0),
									new Tile(3320, 3844, 0), new Tile(3323, 3846, 0),
									new Tile(3325, 3849, 0), new Tile(3326, 3852, 0),
									new Tile(3328, 3855, 0), new Tile(3328, 3858, 0),
									new Tile(3328, 3861, 0), new Tile(3327, 3864, 0),
									new Tile(3326, 3867, 0), new Tile(3324, 3870, 0),
									new Tile(3322, 3873, 0), new Tile(3320, 3876, 0),
									new Tile(3317, 3877, 0), new Tile(3314, 3878, 0),
									new Tile(3311, 3879, 0), new Tile(3308, 3880, 0),
									new Tile(3305, 3880, 0), new Tile(3302, 3880, 0),
									new Tile(3299, 3881, 0), new Tile(3296, 3882, 0),
									new Tile(3293, 3883, 0), new Tile(3290, 3884, 0),
									new Tile(3287, 3885, 0) }, new Obstacle(WILD_BARRIER_ID, null));

}
