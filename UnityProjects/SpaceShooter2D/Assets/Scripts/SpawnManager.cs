using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnManager : MonoBehaviour
{
    [SerializeField]
    private GameObject _enemy;
    [SerializeField]
    private GameObject _spawnedEnemies;

    private Player _player;

    // Start is called before the first frame update
    void Start()
    {
        _player = GameObject.Find("Player").GetComponent<Player>();

        if (_player == null)
        {
            Debug.LogError("Player not found.");

        }

        StartCoroutine(SpawnRoutine());

    }

    // Update is called once per frame
    void Update()
    {
        

    }

    IEnumerator SpawnRoutine()
    {
        while (_player._isDead == false)
        {
            Vector3 spawnPos = new Vector3(Random.Range(-8f, 8f), 7, 0);
            GameObject newEnemy = Instantiate(_enemy, spawnPos, Quaternion.identity);
            newEnemy.transform.parent = _spawnedEnemies.transform;
            yield return new WaitForSeconds(5.0f);

        }
    }
}
