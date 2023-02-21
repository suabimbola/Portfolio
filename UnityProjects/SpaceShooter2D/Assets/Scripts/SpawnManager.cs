using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnManager : MonoBehaviour
{
    [SerializeField]
    private GameObject _enemy;
    [SerializeField]
    private GameObject _spawnedEnemies;
    [SerializeField]
    private GameObject[] _powerUps;
    [SerializeField]
    private GameObject _startText;

    private Player _player;

    void Start()
    {
        _player = GameObject.Find("Player").GetComponent<Player>();

        if (_player == null)
        {
            Debug.LogError("Player not found.");

        }

    }

    public void StartSpawn()
    {
        StartCoroutine(SpawnEnemy());
        StartCoroutine(SpawnPowerUp());

    }

    IEnumerator SpawnEnemy()
    {
        yield return new WaitForSeconds(2f);
        _startText.SetActive(false);

        yield return new WaitForSeconds(1f);
        while (_player._isDead == false)
        {
            Vector3 enemyPos = new Vector3(Random.Range(-8f, 8f), 7, 0);
            GameObject newEnemy = Instantiate(_enemy, enemyPos, Quaternion.identity);
            newEnemy.transform.parent = _spawnedEnemies.transform;
            yield return new WaitForSeconds(5f);

        }
    }

    IEnumerator SpawnPowerUp()
    {
        yield return new WaitForSeconds(Random.Range(3f, 8f));

        while(_player._isDead == false)
        {
            Vector3 powerUpPos = new Vector3(Random.Range(-8f, 8f), 7, 0);
            int randomPowerUp = Random.Range(0, 3);
            Instantiate(_powerUps[randomPowerUp], powerUpPos, Quaternion.identity);
            yield return new WaitForSeconds(Random.Range(3f, 12f));

        }
    }
}
