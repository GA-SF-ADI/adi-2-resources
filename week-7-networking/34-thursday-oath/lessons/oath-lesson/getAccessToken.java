private void getAccessToken(String code){
        Log.d(LoginActivity.class.getName(),"Trying to get access token");

        // Pass in the form data for this post call
        Call<AuthenticationResponse> call = instaGramService.postAccessCode(
                InstagramAppData.CLIENT_SECRET,
                InstagramAppData.CLIENT_ID,
                InstagramAppData.AUTH_CODE_KEY,
                InstagramAppData.CALLBACK_URL,
                code);

        call.enqueue(new retrofit2.Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(retrofit2.Call<AuthenticationResponse> call, retrofit2.Response<AuthenticationResponse> response) {
                // grab the two objects from the response
                AuthenticationResponse authenticationResponse = response.body();
                InstaGramUser user = authenticationResponse.getUser();

                Log.i(TAG, "onResponse: successful access for " + user.getFullName());

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra(INTENT_KEY_TOKEN,authenticationResponse.getToken());
                intent.putExtra(INTENT_KEY_ID, user.getId());
                startActivity(intent);
            }

            @Override
            public void onFailure(retrofit2.Call<AuthenticationResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: getting access token");
            }
        });
    }
