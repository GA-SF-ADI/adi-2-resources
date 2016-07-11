package ly.generalassemb.drewmahrt.userinfotabs;


import android.content.ContentValues;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
                return tab1;
            case 1:
                //TODO: Add your second tab
                AboutMeFragment tab2 = new AboutMeFragment();
                return tab2;
            case 2:
                //TODO: Add your third tab
                ContactFragment tab3 = new ContactFragment();
                return tab3;
            case 3:
                //TODO: Add your third tab
                HomeFragment tab4 = new HomeFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
