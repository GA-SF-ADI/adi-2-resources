package ly.generalassemb.drewmahrt.userinfotabs;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by drewmahrt on 2/18/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PictureFragment tab1 = new PictureFragment();
                Log.d("pageradapter", "frag1");
                return tab1;
            case 1:
                PersonalFragment tab2 = new PersonalFragment();
                //TODO: Add your second tab
                Log.d("pageradapter", "frag2");

                return tab2;
            case 2:
                ContactFragment tab3 = new ContactFragment();
                //TODO: Add your third tab
                Log.d("pageradapter", "frag3");

                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
