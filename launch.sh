set -e
#if [ -z "$1" ]; then
#  echo './launch.sh DEV or ./launch.sh PROD'
#  exit
#elif [ "$1" != DEV ] && [ "$1" != PROD ] && ["$1" != DEV_VIETTEL ]; then
#  echo './launch.sh DEV or ./launch.sh PROD'
#  exit
#fi

#git pull

#./gradlew bootJar
#./gradlew --stop
# shellcheck disable=SC2164
#cd build/libs

if [ "$1" == AUTH_MANAGEMENT ]; then
  echo "Uploading ... "
  scp auth_management/build/libs/auth_management-0.0.1-SNAPSHOT.jar root@157.230.252.237:/app/jars/developers/auth_management-0.0.1-SNAPSHOT.jar
  echo "Uploaded !"
  echo "Deploying !"
  ssh root@157.230.252.237 /app/sh/auth-management.sh

elif [ "$1" == ADMIN_MANAGEMENT ]; then
  echo "Uploading ... "
  scp admin_management/build/libs/admin_management-0.0.1-SNAPSHOT.jar root@157.230.252.237:/app/jars/developers/admin_management-0.0.1-SNAPSHOT.jar
  echo "Uploaded !"
  echo "Deploying !"
  ssh root@157.230.252.237 /app/sh/admin-management.sh

elif [ "$1" == PUBLIC_MANAGEMENT ]; then
  echo "Uploading ... "
  scp public_management/build/libs/public_management-0.0.1-SNAPSHOT.jar root@157.230.252.237:/app/jars/developers/public_management-0.0.1-SNAPSHOT.jar
  echo "Uploaded !"
  echo "Deploying !"
  ssh root@157.230.252.237 /app/sh/public-management.sh

elif [ "$1" == PERMISSION_MANAGEMENT ]; then
  echo "Uploading ... "
  scp permission/build/libs/permission-0.0.1-SNAPSHOT.jar root@157.230.252.237:/app/jars/developers/permission-0.0.1-SNAPSHOT.jar
  echo "Uploaded !"
  echo "Deploying !"
  ssh root@157.230.252.237 /app/sh/permission.sh
fi

echo "Completed !"

# bash -e launch.sh AUTH_MANAGEMENT
# bash -e launch.sh ADMIN_MANAGEMENT
# bash -e launch.sh PUBLIC_MANAGEMENT
# bash -e launch.sh PERMISSION_MANAGEMENT