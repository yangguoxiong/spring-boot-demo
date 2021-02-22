if redis.call('get', KEYS[1]) > ARGV[1]
then
return redis.call('incrby', KEYS[1], ARGV[2])
else
	return 0
end
